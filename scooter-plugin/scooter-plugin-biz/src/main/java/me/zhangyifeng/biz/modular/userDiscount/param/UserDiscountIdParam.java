
package me.zhangyifeng.biz.modular.userDiscount.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

/**
 * UserDiscountId参数
 *
 * @author 张一风
 * @date  2025/03/07 23:09
 **/
@Getter
@Setter
public class UserDiscountIdParam {

    /** ID */
    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;
}
