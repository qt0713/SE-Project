
package me.zhangyifeng.biz.modular.payment.service.impl;

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
import me.zhangyifeng.biz.modular.payment.entity.Payment;
import me.zhangyifeng.biz.modular.payment.mapper.PaymentMapper;
import me.zhangyifeng.biz.modular.payment.param.PaymentAddParam;
import me.zhangyifeng.biz.modular.payment.param.PaymentEditParam;
import me.zhangyifeng.biz.modular.payment.param.PaymentIdParam;
import me.zhangyifeng.biz.modular.payment.param.PaymentPageParam;
import me.zhangyifeng.biz.modular.payment.service.PaymentService;

import java.util.List;

/**
 * PaymentService接口实现类
 *
 * @author 张一风
 * @date  2025/03/07 23:02
 **/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

    @Override
    public Page<Payment> page(PaymentPageParam paymentPageParam) {
        QueryWrapper<Payment> queryWrapper = new QueryWrapper<Payment>().checkSqlInjection();
        if(ObjectUtil.isNotEmpty(paymentPageParam.getPaymentMethod())) {
            queryWrapper.lambda().eq(Payment::getPaymentMethod, paymentPageParam.getPaymentMethod());
        }
        if(ObjectUtil.isNotEmpty(paymentPageParam.getTransactionReference())) {
            queryWrapper.lambda().eq(Payment::getTransactionReference, paymentPageParam.getTransactionReference());
        }
        if(ObjectUtil.isNotEmpty(paymentPageParam.getStatus())) {
            queryWrapper.lambda().eq(Payment::getStatus, paymentPageParam.getStatus());
        }
        if(ObjectUtil.isNotEmpty(paymentPageParam.getStartCreateTime()) && ObjectUtil.isNotEmpty(paymentPageParam.getEndCreateTime())) {
            queryWrapper.lambda().between(Payment::getCreateTime, paymentPageParam.getStartCreateTime(), paymentPageParam.getEndCreateTime());
        }
        if(ObjectUtil.isAllNotEmpty(paymentPageParam.getSortField(), paymentPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(paymentPageParam.getSortOrder());
            queryWrapper.orderBy(true, paymentPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()),
                    StrUtil.toUnderlineCase(paymentPageParam.getSortField()));
        } else {
            queryWrapper.lambda().orderByAsc(Payment::getId);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(PaymentAddParam paymentAddParam) {
        Payment payment = BeanUtil.toBean(paymentAddParam, Payment.class);
        this.save(payment);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(PaymentEditParam paymentEditParam) {
        Payment payment = this.queryEntity(paymentEditParam.getId());
        BeanUtil.copyProperties(paymentEditParam, payment);
        this.updateById(payment);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<PaymentIdParam> paymentIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(paymentIdParamList, PaymentIdParam::getId));
    }

    @Override
    public Payment detail(PaymentIdParam paymentIdParam) {
        return this.queryEntity(paymentIdParam.getId());
    }

    @Override
    public Payment queryEntity(String id) {
        Payment payment = this.getById(id);
        if(ObjectUtil.isEmpty(payment)) {
            throw new CommonException("Payment不存在，id值为：{}", id);
        }
        return payment;
    }
}
