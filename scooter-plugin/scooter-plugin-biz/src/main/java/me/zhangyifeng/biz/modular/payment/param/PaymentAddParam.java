
package me.zhangyifeng.biz.modular.payment.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Payment添加参数
 *
 * @author 张一风
 * @date  2025/03/07 23:02
 **/
@Getter
@Setter
public class PaymentAddParam {

    /** PAYMENT_METHOD */
    @Schema(description = "PAYMENT_METHOD")
    private String paymentMethod;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

}
