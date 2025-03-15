
package me.zhangyifeng.biz.modular.creditcard.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

/**
 * CreditCardId参数
 *
 * @author 张一风
 * @date  2025/03/09 11:38
 **/
@Getter
@Setter
public class CreditcardIdParam {

    /** ID */
    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;
}
