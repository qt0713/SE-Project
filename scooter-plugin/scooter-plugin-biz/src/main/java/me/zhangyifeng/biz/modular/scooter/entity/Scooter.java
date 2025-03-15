
package me.zhangyifeng.biz.modular.scooter.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Scooter实体
 *
 * @author 张一风
 * @date  2025/03/07 22:51
 **/
@Getter
@Setter
@TableName("Scooter")
public class Scooter {

    /** ID */
    @TableId
    @Schema(description = "ID")
    private String id;

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

    /** CREATE_TIME */
    @Schema(description = "CREATE_TIME")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** UPDATE_TIME */
    @Schema(description = "UPDATE_TIME")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
