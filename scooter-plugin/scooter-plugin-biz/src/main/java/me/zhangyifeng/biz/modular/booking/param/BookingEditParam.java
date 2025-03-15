
package me.zhangyifeng.biz.modular.booking.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * booking编辑参数
 *
 * @author 张一风
 * @date  2025/03/07 22:30
 **/
@Getter
@Setter
public class BookingEditParam {

    /** ID */
    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** OPTION_ID */
    @Schema(description = "OPTION_ID")
    private String optionId;

    /** START_TIME */
    @Schema(description = "START_TIME")
    private Date startTime;

    /** END_TIME */
    @Schema(description = "END_TIME")
    private Date endTime;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

    /** TOTAL_PRICE */
    @Schema(description = "TOTAL_PRICE")
    private BigDecimal totalPrice;

}
