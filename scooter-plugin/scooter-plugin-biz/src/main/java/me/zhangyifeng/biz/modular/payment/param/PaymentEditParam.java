
package me.zhangyifeng.biz.modular.payment.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Payment编辑参数
 *
 * @author 张一风
 * @date  2025/03/07 23:02
 **/
@Getter
@Setter
public class PaymentEditParam {

    /** ID */
    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** PAYMENT_METHOD */
    @Schema(description = "PAYMENT_METHOD")
    private String paymentMethod;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

}
