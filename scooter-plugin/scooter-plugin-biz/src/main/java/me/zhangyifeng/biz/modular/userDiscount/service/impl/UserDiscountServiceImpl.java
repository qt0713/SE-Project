
package me.zhangyifeng.biz.modular.userDiscount.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.xiaonuo.common.enums.CommonSortOrderEnum;
import vip.xiaonuo.common.exception.CommonException;
import vip.xiaonuo.common.page.CommonPageRequest;
import me.zhangyifeng.biz.modular.userDiscount.entity.UserDiscount;
import me.zhangyifeng.biz.modular.userDiscount.mapper.UserDiscountMapper;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountAddParam;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountEditParam;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountIdParam;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountPageParam;
import me.zhangyifeng.biz.modular.userDiscount.service.UserDiscountService;

import java.util.List;

/**
 * UserDiscountService接口实现类
 *
 * @author 张一风
 * @date  2025/03/07 23:09
 **/
@Service
public class UserDiscountServiceImpl extends ServiceImpl<UserDiscountMapper, UserDiscount> implements UserDiscountService {

    @Override
    public Page<UserDiscount> page(UserDiscountPageParam userDiscountPageParam) {
        QueryWrapper<UserDiscount> queryWrapper = new QueryWrapper<UserDiscount>().checkSqlInjection();
        if(ObjectUtil.isNotEmpty(userDiscountPageParam.getUserId())) {
            queryWrapper.lambda().like(UserDiscount::getUserId, userDiscountPageParam.getUserId());
        }
        if(ObjectUtil.isNotEmpty(userDiscountPageParam.getDiscountType())) {
            queryWrapper.lambda().eq(UserDiscount::getDiscountType, userDiscountPageParam.getDiscountType());
        }
        if(ObjectUtil.isNotEmpty(userDiscountPageParam.getStartValidFrom()) && ObjectUtil.isNotEmpty(userDiscountPageParam.getEndValidFrom())) {
            queryWrapper.lambda().between(UserDiscount::getValidFrom, userDiscountPageParam.getStartValidFrom(), userDiscountPageParam.getEndValidFrom());
        }
        if(ObjectUtil.isNotEmpty(userDiscountPageParam.getStartValidUntil()) && ObjectUtil.isNotEmpty(userDiscountPageParam.getEndValidUntil())) {
            queryWrapper.lambda().between(UserDiscount::getValidUntil, userDiscountPageParam.getStartValidUntil(), userDiscountPageParam.getEndValidUntil());
        }
        if(ObjectUtil.isNotEmpty(userDiscountPageParam.getStartCreateTime()) && ObjectUtil.isNotEmpty(userDiscountPageParam.getEndCreateTime())) {
            queryWrapper.lambda().between(UserDiscount::getCreateTime, userDiscountPageParam.getStartCreateTime(), userDiscountPageParam.getEndCreateTime());
        }
        if(ObjectUtil.isNotEmpty(userDiscountPageParam.getStartUpdateTime()) && ObjectUtil.isNotEmpty(userDiscountPageParam.getEndUpdateTime())) {
            queryWrapper.lambda().between(UserDiscount::getUpdateTime, userDiscountPageParam.getStartUpdateTime(), userDiscountPageParam.getEndUpdateTime());
        }
        if(ObjectUtil.isAllNotEmpty(userDiscountPageParam.getSortField(), userDiscountPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(userDiscountPageParam.getSortOrder());
            queryWrapper.orderBy(true, userDiscountPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()),
                    StrUtil.toUnderlineCase(userDiscountPageParam.getSortField()));
        } else {
            queryWrapper.lambda().orderByAsc(UserDiscount::getId);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(UserDiscountAddParam userDiscountAddParam) {
        UserDiscount userDiscount = BeanUtil.toBean(userDiscountAddParam, UserDiscount.class);
        this.save(userDiscount);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(UserDiscountEditParam userDiscountEditParam) {
        UserDiscount userDiscount = this.queryEntity(userDiscountEditParam.getId());
        BeanUtil.copyProperties(userDiscountEditParam, userDiscount);
        this.updateById(userDiscount);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<UserDiscountIdParam> userDiscountIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(userDiscountIdParamList, UserDiscountIdParam::getId));
    }

    @Override
    public UserDiscount detail(UserDiscountIdParam userDiscountIdParam) {
        return this.queryEntity(userDiscountIdParam.getId());
    }

    @Override
    public UserDiscount queryEntity(String id) {
        UserDiscount userDiscount = this.getById(id);
        if(ObjectUtil.isEmpty(userDiscount)) {
            throw new CommonException("UserDiscount不存在，id值为：{}", id);
        }
        return userDiscount;
    }
}
