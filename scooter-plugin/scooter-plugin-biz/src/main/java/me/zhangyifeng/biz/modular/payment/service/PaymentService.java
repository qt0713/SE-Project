
package me.zhangyifeng.biz.modular.payment.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.zhangyifeng.biz.modular.payment.entity.Payment;
import me.zhangyifeng.biz.modular.payment.param.PaymentAddParam;
import me.zhangyifeng.biz.modular.payment.param.PaymentEditParam;
import me.zhangyifeng.biz.modular.payment.param.PaymentIdParam;
import me.zhangyifeng.biz.modular.payment.param.PaymentPageParam;

import java.util.List;

/**
 * PaymentService接口
 *
 * @author 张一风
 * @date  2025/03/07 23:02
 **/
public interface PaymentService extends IService<Payment> {

    /**
     * 获取Payment分页
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    Page<Payment> page(PaymentPageParam paymentPageParam);

    /**
     * 添加Payment
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    void add(PaymentAddParam paymentAddParam);

    /**
     * 编辑Payment
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    void edit(PaymentEditParam paymentEditParam);

    /**
     * 删除Payment
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    void delete(List<PaymentIdParam> paymentIdParamList);

    /**
     * 获取Payment详情
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    Payment detail(PaymentIdParam paymentIdParam);

    /**
     * 获取Payment详情
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     **/
    Payment queryEntity(String id);
}
