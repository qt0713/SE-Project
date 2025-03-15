
package me.zhangyifeng.biz.modular.rentalOption.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * RentalOption添加参数
 *
 * @author 张一风
 * @date  2025/03/07 22:56
 **/
@Getter
@Setter
public class RentalOptionAddParam {

    /** OPTION_NAME */
    @Schema(description = "OPTION_NAME")
    private String optionName;

    /** DURATION_HOURS */
    @Schema(description = "DURATION_HOURS", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "durationHours不能为空")
    private Integer durationHours;

    /** BASE_PRICE */
    @Schema(description = "BASE_PRICE")
    private BigDecimal basePrice;

    /** DESCRIPTION */
    @Schema(description = "DESCRIPTION")
    private String description;

}
