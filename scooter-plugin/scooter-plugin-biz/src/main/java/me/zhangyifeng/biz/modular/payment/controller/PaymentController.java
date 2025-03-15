
package me.zhangyifeng.biz.modular.payment.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;
import me.zhangyifeng.biz.modular.payment.entity.Payment;
import me.zhangyifeng.biz.modular.payment.param.PaymentAddParam;
import me.zhangyifeng.biz.modular.payment.param.PaymentEditParam;
import me.zhangyifeng.biz.modular.payment.param.PaymentIdParam;
import me.zhangyifeng.biz.modular.payment.param.PaymentPageParam;
import me.zhangyifeng.biz.modular.payment.service.PaymentService;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Payment控制器
 *
 * @author 张一风
 * @date  2025/03/07 23:02
 */
@Tag(name = "Payment控制器")
@RestController
@Validated
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 获取Payment分页
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    @Operation(summary = "获取Payment分页")
    @SaCheckPermission("/biz/payment/page")
    @GetMapping("/biz/payment/page")
    public CommonResult<Page<Payment>> page(PaymentPageParam paymentPageParam) {
        return CommonResult.data(paymentService.page(paymentPageParam));
    }

    /**
     * 添加Payment
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    @Operation(summary = "添加Payment")
    @CommonLog("添加Payment")
    @SaCheckPermission("/biz/payment/add")
    @PostMapping("/biz/payment/add")
    public CommonResult<String> add(@RequestBody @Valid PaymentAddParam paymentAddParam) {
        paymentService.add(paymentAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑Payment
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    @Operation(summary = "编辑Payment")
    @CommonLog("编辑Payment")
    @SaCheckPermission("/biz/payment/edit")
    @PostMapping("/biz/payment/edit")
    public CommonResult<String> edit(@RequestBody @Valid PaymentEditParam paymentEditParam) {
        paymentService.edit(paymentEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除Payment
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    @Operation(summary = "删除Payment")
    @CommonLog("删除Payment")
    @SaCheckPermission("/biz/payment/delete")
    @PostMapping("/biz/payment/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                   List<PaymentIdParam> paymentIdParamList) {
        paymentService.delete(paymentIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取Payment详情
     *
     * @author 张一风
     * @date  2025/03/07 23:02
     */
    @Operation(summary = "获取Payment详情")
    @SaCheckPermission("/biz/payment/detail")
    @GetMapping("/biz/payment/detail")
    public CommonResult<Payment> detail(@Valid PaymentIdParam paymentIdParam) {
        return CommonResult.data(paymentService.detail(paymentIdParam));
    }
}
