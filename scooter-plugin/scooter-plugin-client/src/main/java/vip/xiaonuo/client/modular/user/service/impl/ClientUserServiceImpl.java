
package vip.xiaonuo.client.modular.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhs.trans.service.impl.TransService;
import jakarta.annotation.Resource;
import me.zhangyifeng.modular.user.enums.ClientUserExceptionEnum;
import me.zhangyifeng.modular.user.param.ClientUserRegisterParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.xiaonuo.auth.core.enums.SaClientTypeEnum;
import vip.xiaonuo.auth.modular.login.enums.AuthExceptionEnum;
import vip.xiaonuo.client.modular.relation.service.ClientRelationService;
import vip.xiaonuo.client.modular.user.entity.ClientUser;
import vip.xiaonuo.client.modular.user.enums.ClientUserStatusEnum;
import vip.xiaonuo.client.modular.user.mapper.ClientUserMapper;
import vip.xiaonuo.client.modular.user.param.ClientUserAddParam;
import vip.xiaonuo.client.modular.user.param.ClientUserEditParam;
import vip.xiaonuo.client.modular.user.param.ClientUserIdParam;
import vip.xiaonuo.client.modular.user.param.ClientUserPageParam;
import vip.xiaonuo.client.modular.user.result.ClientLoginUser;
import vip.xiaonuo.client.modular.user.service.ClientUserService;
import vip.xiaonuo.common.cache.CommonCacheOperator;
import vip.xiaonuo.common.enums.CommonSortOrderEnum;
import vip.xiaonuo.common.exception.CommonException;
import vip.xiaonuo.common.page.CommonPageRequest;
import vip.xiaonuo.common.util.*;
import vip.xiaonuo.dev.api.DevConfigApi;
import vip.xiaonuo.auth.modular.login.service.AuthService;
import vip.xiaonuo.dev.api.DevEmailApi;

import java.util.List;

/**
 * C端用户Service接口实现类
 *
 * @author xuyuxiang
 * @date 2022/2/23 18:43
 **/
@Service
public class ClientUserServiceImpl extends ServiceImpl<ClientUserMapper, ClientUser> implements ClientUserService {

    private static final String SNOWY_SYS_DEFAULT_PASSWORD_KEY = "SNOWY_SYS_DEFAULT_PASSWORD";
    private static final String SNOWY_SYS_DEFAULT_CAPTCHA_OPEN_KEY = "SNOWY_SYS_DEFAULT_CAPTCHA_OPEN";
    private static final String USER_REGISTER_CODE_CACHE_KEY = "register-validCode:";

    @Resource
    private DevConfigApi devConfigApi;

    @Resource
    private CommonCacheOperator commonCacheOperator;

    @Resource
    private DevEmailApi devEmailApi;

    @Resource
    private TransService transService;

    @Resource
    private AuthService authService;

    @Resource
    private ClientRelationService clientRelationService;

    @Override
    public ClientLoginUser getUserById(String id) {
        ClientUser clientUser = this.getById(id);
        if (ObjectUtil.isNotEmpty(clientUser)) {
            transService.transOne(clientUser);
            return BeanUtil.copyProperties(clientUser, ClientLoginUser.class);
        }
        return null;
    }

    @Override
    public ClientLoginUser getUserByAccount(String account) {
        ClientUser clientUser = this.getOne(new LambdaQueryWrapper<ClientUser>().eq(ClientUser::getAccount, account));
        if (ObjectUtil.isNotEmpty(clientUser)) {
            transService.transOne(clientUser);
            return BeanUtil.copyProperties(clientUser, ClientLoginUser.class);
        }
        return null;
    }

    @Override
    public ClientLoginUser getUserByPhone(String phone) {
        ClientUser clientUser = this.getOne(new LambdaQueryWrapper<ClientUser>().eq(ClientUser::getPhone, CommonCryptogramUtil.doSm4CbcEncrypt(phone)));
        if (ObjectUtil.isNotEmpty(clientUser)) {
            transService.transOne(clientUser);
            return BeanUtil.copyProperties(clientUser, ClientLoginUser.class);
        }
        return null;
    }

    @Override
    public ClientLoginUser getUserByEmail(String email) {
        ClientUser clientUser = this.getOne(new LambdaQueryWrapper<ClientUser>().eq(ClientUser::getEmail, email));
        if (ObjectUtil.isNotEmpty(clientUser)) {
            transService.transOne(clientUser);
            return BeanUtil.copyProperties(clientUser, ClientLoginUser.class);
        }
        return null;
    }

    @Override
    public Page<ClientUser> page(ClientUserPageParam clientUserPageParam) {
        QueryWrapper<ClientUser> queryWrapper = new QueryWrapper<ClientUser>().checkSqlInjection();
        if (ObjectUtil.isNotEmpty(clientUserPageParam.getSearchKey())) {
            queryWrapper.lambda().and(q -> q.like(ClientUser::getName, clientUserPageParam.getSearchKey())
                    .or().like(ClientUser::getAccount, clientUserPageParam.getSearchKey()));
        }
        if (ObjectUtil.isAllNotEmpty(clientUserPageParam.getSortField(), clientUserPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(clientUserPageParam.getSortOrder());
            queryWrapper.orderBy(true, clientUserPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()),
                    StrUtil.toUnderlineCase(clientUserPageParam.getSortField()));
        } else {
            queryWrapper.lambda().orderByAsc(ClientUser::getSortCode);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(ClientUserAddParam clientUserAddParam) {
        checkParam(clientUserAddParam);
        ClientUser clientUser = BeanUtil.toBean(clientUserAddParam, ClientUser.class);
        if (ObjectUtil.isEmpty(clientUser.getAvatar())) {
            // 设置默认头像
            clientUser.setAvatar(CommonAvatarUtil.generateImg(clientUser.getName()));
        }
        // 设置默认密码
        clientUser.setPassword(CommonCryptogramUtil.doHashValue(devConfigApi.getValueByKey(SNOWY_SYS_DEFAULT_PASSWORD_KEY)));
        // 设置状态
        clientUser.setUserStatus(ClientUserStatusEnum.ENABLE.getValue());
        this.save(clientUser);
    }

    private void checkParam(ClientUserAddParam clientUserAddParam) {
        if (this.count(new LambdaQueryWrapper<ClientUser>()
                .eq(ClientUser::getAccount, clientUserAddParam.getAccount())) > 0) {
            throw new CommonException("存在重复的账号，账号为：{}", clientUserAddParam.getAccount());
        }
        if (ObjectUtil.isNotEmpty(clientUserAddParam.getPhone())) {
            if (!PhoneUtil.isMobile(clientUserAddParam.getPhone())) {
                throw new CommonException("手机号码：{}格式错误", clientUserAddParam.getPhone());
            }
            if (this.count(new LambdaQueryWrapper<ClientUser>()
                    .eq(ClientUser::getPhone, CommonCryptogramUtil.doSm4CbcEncrypt(clientUserAddParam.getPhone()))) > 0) {
                throw new CommonException("存在重复的手机号，手机号为：{}", clientUserAddParam.getPhone());
            }
        }
        if (ObjectUtil.isNotEmpty(clientUserAddParam.getEmail())) {
            if (!CommonEmailUtil.isEmail(clientUserAddParam.getEmail())) {
                throw new CommonException("邮箱：{}格式错误", clientUserAddParam.getEmail());
            }
            if (this.count(new LambdaQueryWrapper<ClientUser>()
                    .eq(ClientUser::getEmail, clientUserAddParam.getEmail())) > 0) {
                throw new CommonException("存在重复的邮箱，邮箱为：{}", clientUserAddParam.getEmail());
            }
        }
    }

    @Override
    public void edit(ClientUserEditParam clientUserEditParam) {
        ClientUser clientUser = this.queryEntity(clientUserEditParam.getId());
        checkParam(clientUserEditParam);
        BeanUtil.copyProperties(clientUserEditParam, clientUser);
        this.updateById(clientUser);
    }

    private void checkParam(ClientUserEditParam clientUserEditParam) {
        if (this.count(new LambdaQueryWrapper<ClientUser>()
                .eq(ClientUser::getAccount, clientUserEditParam.getAccount())
                .ne(ClientUser::getId, clientUserEditParam.getId())) > 0) {
            throw new CommonException("存在重复的账号，账号为：{}", clientUserEditParam.getAccount());
        }
        if (ObjectUtil.isNotEmpty(clientUserEditParam.getPhone())) {
            if (!PhoneUtil.isMobile(clientUserEditParam.getPhone())) {
                throw new CommonException("手机号码：{}格式错误", clientUserEditParam.getPhone());
            }
            if (this.count(new LambdaQueryWrapper<ClientUser>()
                    .eq(ClientUser::getPhone, CommonCryptogramUtil.doSm4CbcEncrypt(clientUserEditParam.getPhone()))
                    .ne(ClientUser::getId, clientUserEditParam.getId())) > 0) {
                throw new CommonException("存在重复的手机号，手机号为：{}", clientUserEditParam.getPhone());
            }
        }
        if (ObjectUtil.isNotEmpty(clientUserEditParam.getEmail())) {
            if (!CommonEmailUtil.isEmail(clientUserEditParam.getEmail())) {
                throw new CommonException("邮箱：{}格式错误", clientUserEditParam.getEmail());
            }
            if (this.count(new LambdaQueryWrapper<ClientUser>()
                    .eq(ClientUser::getEmail, clientUserEditParam.getEmail())
                    .ne(ClientUser::getId, clientUserEditParam.getId())) > 0) {
                throw new CommonException("存在重复的邮箱，邮箱为：{}", clientUserEditParam.getEmail());
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<ClientUserIdParam> clientUserIdParamList) {
        this.removeByIds(CollStreamUtil.toList(clientUserIdParamList, ClientUserIdParam::getId));
    }

    @Override
    public ClientUser detail(ClientUserIdParam clientUserIdParam) {
        return this.queryEntity(clientUserIdParam.getId());
    }

    @Override
    public void updateUserLoginInfo(String userId, String device) {
        ClientUser clientUser = this.queryEntity(userId);
        clientUser.setLastLoginTime(clientUser.getLatestLoginTime());
        clientUser.setLastLoginIp(clientUser.getLatestLoginIp());
        clientUser.setLastLoginAddress(clientUser.getLatestLoginAddress());
        clientUser.setLastLoginDevice(clientUser.getLatestLoginDevice());
        clientUser.setLatestLoginTime(DateTime.now());
        String ip = CommonIpAddressUtil.getIp(CommonServletUtil.getRequest());
        clientUser.setLatestLoginIp(ip);
        clientUser.setLatestLoginAddress(CommonIpAddressUtil.getCityInfo(ip));
        clientUser.setLatestLoginDevice(device);
        this.updateById(clientUser);
    }

    @Override
    public ClientUser queryEntity(String id) {
        ClientUser clientUser = this.getById(id);
        if (ObjectUtil.isEmpty(clientUser)) {
            throw new CommonException("用户不存在，id值为：{}", id);
        }
        return clientUser;
    }


    @Override
    public void register(ClientUserRegisterParam clientUserRegisterParam) {
        ClientUser clientUser = BeanUtil.toBean(clientUserRegisterParam, ClientUser.class);
        if (ObjectUtil.isNotEmpty(clientUser.getPhone())) {
            // 手机号注册
            // 手机号是否存在
            if (this.count(new LambdaQueryWrapper<ClientUser>().eq(ClientUser::getPhone, CommonCryptogramUtil.doSm4CbcEncrypt(clientUser.getPhone()))) > 0) {
                throw new CommonException("手机号已存在，手机号为：{}", clientUser.getPhone());
            }
            // 校验验证码
            String validCode = clientUserRegisterParam.getValidCode();
            // 获取验证码请求号
            String validCodeReqNo = clientUserRegisterParam.getValidCodeReqNo();
            // 开启验证码则必须传入验证码
            if (ObjectUtil.isEmpty(validCode)) {
                throw new CommonException(AuthExceptionEnum.VALID_CODE_EMPTY.getValue());
            }
            // 开启验证码则必须传入验证码请求号
            if (ObjectUtil.isEmpty(validCodeReqNo)) {
                throw new CommonException(AuthExceptionEnum.VALID_CODE_REQ_NO_EMPTY.getValue());
            }
            // 执行校验验证码
            String type = SaClientTypeEnum.C.getValue();
            authService.validPhoneValidCodeParam(clientUser.getPhone(), validCode, validCodeReqNo, type);
        } else {
            // 邮箱注册
            // 邮箱是否存在
            if (this.count(new LambdaQueryWrapper<ClientUser>().eq(ClientUser::getEmail, clientUser.getEmail())) > 0) {
                throw new CommonException("邮箱已存在，邮箱为：{}", clientUser.getEmail());
            }
            // 获取验证码
            String validCode = clientUserRegisterParam.getValidCode();
            // 获取验证码请求号
            String validCodeReqNo = clientUserRegisterParam.getValidCodeReqNo();
            // 开启验证码则必须传入验证码
            if (ObjectUtil.isEmpty(validCode)) {
                throw new CommonException(AuthExceptionEnum.VALID_CODE_EMPTY.getValue());
            }
            // 开启验证码则必须传入验证码请求号
            if (ObjectUtil.isEmpty(validCodeReqNo)) {
                throw new CommonException(AuthExceptionEnum.VALID_CODE_REQ_NO_EMPTY.getValue());
            }
            // 执行校验验证码
            // 不一致则直接验证码错误
            String key = USER_REGISTER_CODE_CACHE_KEY + clientUser.getEmail() + StrUtil.UNDERLINE + validCodeReqNo;
            String existValidCode = (String)commonCacheOperator.get(key);
            if (!validCode.equalsIgnoreCase(Convert.toStr(existValidCode))) {
                throw new CommonException("Verification code error");
            }
            commonCacheOperator.remove(USER_REGISTER_CODE_CACHE_KEY + clientUser.getEmail() + StrUtil.UNDERLINE + validCodeReqNo);
        }
        if (ObjectUtil.isEmpty(clientUser.getAvatar())) {
            // 设置默认头像
            clientUser.setAvatar(CommonAvatarUtil.generateImg(clientUser.getAccount()));
        }
        // 设置状态
        clientUser.setUserStatus(ClientUserStatusEnum.ENABLE.getValue());
        // 设置密码
        clientUser.setPassword(CommonCryptogramUtil.doHashValue(clientUserRegisterParam.getPassword()));
        this.save(clientUser);
    }

    @Override
    public String sendEmailCaptcha(String email) {
        // 验证码正确则校验邮箱格式
        if (!CommonEmailUtil.isEmail(email)) {
            throw new CommonException("邮箱：{}格式错误", email);
        }
        // 判断邮箱是否存在
        if (this.count(new LambdaQueryWrapper<ClientUser>().eq(ClientUser::getEmail, email)) > 0) {
            throw new CommonException(ClientUserExceptionEnum.EMAIL_EXISTED.getValue());
        }
        // 生成邮箱验证码的值，随机6为数字
        String emailValidCode = RandomUtil.randomNumbers(6);
        // 生成邮箱验证码的请求号
        String emailValidCodeReqNo = IdWorker.getIdStr();

        // TODO 使用本地发送邮件
        String content = "Welcome to ScooterRental.\nThe verification code：" + emailValidCode + " valid for 5 minutes.";
        devEmailApi.sendTextEmailLocal(email, "Welcome to ScooterRental", content, CollectionUtil.newArrayList());

        // 将请求号作为key，验证码的值作为value放到redis，用于校验，5分钟有效
        commonCacheOperator.put(USER_REGISTER_CODE_CACHE_KEY + email + StrUtil.UNDERLINE + emailValidCodeReqNo, emailValidCode, 5 * 60);
        // 返回请求号
        return emailValidCodeReqNo;
    }
}
