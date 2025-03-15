
package me.zhangyifeng.biz.modular.creditcard.service.impl;

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
import me.zhangyifeng.biz.modular.creditcard.entity.Creditcard;
import me.zhangyifeng.biz.modular.creditcard.mapper.CreditcardMapper;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardAddParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardEditParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardIdParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardPageParam;
import me.zhangyifeng.biz.modular.creditcard.service.CreditcardService;
import vip.xiaonuo.common.enums.CommonSortOrderEnum;
import vip.xiaonuo.common.exception.CommonException;
import vip.xiaonuo.common.page.CommonPageRequest;

import java.util.List;

/**
 * CreditCardService接口实现类
 *
 * @author 张一风
 * @date  2025/03/09 11:38
 **/
@Service
public class CreditcardServiceImpl extends ServiceImpl<CreditcardMapper, Creditcard> implements CreditcardService {

    @Override
    public Page<Creditcard> page(CreditcardPageParam creditcardPageParam) {
        QueryWrapper<Creditcard> queryWrapper = new QueryWrapper<Creditcard>().checkSqlInjection();
        if(ObjectUtil.isNotEmpty(creditcardPageParam.getUserId())) {
            queryWrapper.lambda().like(Creditcard::getUserId, creditcardPageParam.getUserId());
        }
        if(ObjectUtil.isNotEmpty(creditcardPageParam.getCardHolder())) {
            queryWrapper.lambda().like(Creditcard::getCardHolder, creditcardPageParam.getCardHolder());
        }
        if(ObjectUtil.isNotEmpty(creditcardPageParam.getStartCreateTime()) && ObjectUtil.isNotEmpty(creditcardPageParam.getEndCreateTime())) {
            queryWrapper.lambda().between(Creditcard::getCreateTime, creditcardPageParam.getStartCreateTime(), creditcardPageParam.getEndCreateTime());
        }
        if(ObjectUtil.isNotEmpty(creditcardPageParam.getStartUpdateTime()) && ObjectUtil.isNotEmpty(creditcardPageParam.getEndUpdateTime())) {
            queryWrapper.lambda().between(Creditcard::getUpdateTime, creditcardPageParam.getStartUpdateTime(), creditcardPageParam.getEndUpdateTime());
        }
        if(ObjectUtil.isAllNotEmpty(creditcardPageParam.getSortField(), creditcardPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(creditcardPageParam.getSortOrder());
            queryWrapper.orderBy(true, creditcardPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()),
                    StrUtil.toUnderlineCase(creditcardPageParam.getSortField()));
        } else {
            queryWrapper.lambda().orderByAsc(Creditcard::getId);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(CreditcardAddParam creditcardAddParam) {
        Creditcard creditcard = BeanUtil.toBean(creditcardAddParam, Creditcard.class);
        this.save(creditcard);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(CreditcardEditParam creditcardEditParam) {
        Creditcard creditcard = this.queryEntity(creditcardEditParam.getId());
        BeanUtil.copyProperties(creditcardEditParam, creditcard);
        this.updateById(creditcard);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<CreditcardIdParam> creditcardIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(creditcardIdParamList, CreditcardIdParam::getId));
    }

    @Override
    public Creditcard detail(CreditcardIdParam creditcardIdParam) {
        return this.queryEntity(creditcardIdParam.getId());
    }

    @Override
    public Creditcard queryEntity(String id) {
        Creditcard creditcard = this.getById(id);
        if(ObjectUtil.isEmpty(creditcard)) {
            throw new CommonException("CreditCard不存在，id值为：{}", id);
        }
        return creditcard;
    }
}
