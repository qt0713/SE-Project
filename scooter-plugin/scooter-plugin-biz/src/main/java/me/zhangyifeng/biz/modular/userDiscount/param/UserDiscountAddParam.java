
package me.zhangyifeng.biz.modular.userDiscount.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * UserDiscount添加参数
 *
 * @author 张一风
 * @date  2025/03/07 23:09
 **/
@Getter
@Setter
public class UserDiscountAddParam {

    /** USER_ID */
    @Schema(description = "USER_ID")
    private String userId;

    /** DISCOUNT_TYPE */
    @Schema(description = "DISCOUNT_TYPE", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "discountType不能为空")
    private String discountType;

    /** DISCOUNT_PERCENTAGE */
    @Schema(description = "DISCOUNT_PERCENTAGE")
    private BigDecimal discountPercentage;

    /** VALID_FROM */
    @Schema(description = "VALID_FROM")
    private Date validFrom;

    /** VALID_UNTIL */
    @Schema(description = "VALID_UNTIL")
    private Date validUntil;

    /** PROOF_DOCUMENT */
    @Schema(description = "PROOF_DOCUMENT")
    private String proofDocument;

}
