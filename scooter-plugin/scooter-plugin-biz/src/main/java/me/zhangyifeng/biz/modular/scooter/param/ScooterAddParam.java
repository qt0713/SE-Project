
package me.zhangyifeng.biz.modular.scooter.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Scooter添加参数
 *
 * @author 张一风
 * @date  2025/03/07 22:51
 **/
@Getter
@Setter
public class ScooterAddParam {

    /** MODEL */
    @Schema(description = "MODEL")
    private String model;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

    /** LOCATION */
    @Schema(description = "LOCATION")
    private String location;

    /** BATTERY_LEVEL */
    @Schema(description = "BATTERY_LEVEL")
    private Integer batteryLevel;

    /** LAST_MAINTENANCE_DATE */
    @Schema(description = "LAST_MAINTENANCE_DATE")
    private Date lastMaintenanceDate;

}
