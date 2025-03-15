
package me.zhangyifeng.biz.modular.booking.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

/**
 * bookingId参数
 *
 * @author 张一风
 * @date  2025/03/07 22:30
 **/
@Getter
@Setter
public class BookingIdParam {

    /** ID */
    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;
}
