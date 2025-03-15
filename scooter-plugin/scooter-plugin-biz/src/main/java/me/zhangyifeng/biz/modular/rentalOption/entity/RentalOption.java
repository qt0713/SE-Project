
package me.zhangyifeng.biz.modular.rentalOption.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * RentalOption实体
 *
 * @author 张一风
 * @date  2025/03/07 22:56
 **/
@Getter
@Setter
@TableName("RentalOption")
public class RentalOption {

    /** ID */
    @TableId
    @Schema(description = "ID")
    private String id;

    /** OPTION_NAME */
    @Schema(description = "OPTION_NAME")
    private String optionName;

    /** DURATION_HOURS */
    @Schema(description = "DURATION_HOURS")
    private Integer durationHours;

    /** BASE_PRICE */
    @Schema(description = "BASE_PRICE")
    private BigDecimal basePrice;

    /** DESCRIPTION */
    @Schema(description = "DESCRIPTION")
    private String description;

    /** CREATE_TIME */
    @Schema(description = "CREATE_TIME")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** UPDATE_TIME */
    @Schema(description = "UPDATE_TIME")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
