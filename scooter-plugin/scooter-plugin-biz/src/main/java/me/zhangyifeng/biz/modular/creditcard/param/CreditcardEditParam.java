
package me.zhangyifeng.biz.modular.creditcard.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * CreditCard编辑参数
 *
 * @author 张一风
 * @date  2025/03/09 11:38
 **/
@Getter
@Setter
public class CreditcardEditParam {

    /** ID */
    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** USER_ID */
    @Schema(description = "USER_ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String userId;

    /** CARD_NUMBER */
    @Schema(description = "CARD_NUMBER", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "cardNumber不能为空")
    private String cardNumber;

    /** CARD_HOLDER */
    @Schema(description = "CARD_HOLDER")
    private String cardHolder;

    /** EXPIRY_DATE */
    @Schema(description = "EXPIRY_DATE")
    private String expiryDate;

    /** CVV */
    @Schema(description = "CVV")
    private String cvv;

    /** IS_DEFAULT */
    @Schema(description = "IS_DEFAULT")
    private Integer isDefault;

}
