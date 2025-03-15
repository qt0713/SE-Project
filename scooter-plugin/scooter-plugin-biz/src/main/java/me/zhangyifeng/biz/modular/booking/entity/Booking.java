
package me.zhangyifeng.biz.modular.booking.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * booking实体
 *
 * @author 张一风
 * @date  2025/03/07 22:30
 **/
@Getter
@Setter
@TableName("Booking")
public class Booking {

    /** ID */
    @TableId
    @Schema(description = "ID")
    private String id;

    /** USER_ID */
    @Schema(description = "USER_ID")
    private String userId;

    /** SCOOTER_ID */
    @Schema(description = "SCOOTER_ID")
    private String scooterId;

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

    /** BOOKING_REFERENCE */
    @Schema(description = "BOOKING_REFERENCE")
    private String bookingReference;

    /** CREATE_TIME */
    @Schema(description = "CREATE_TIME")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** UPDATE_TIME */
    @Schema(description = "UPDATE_TIME")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
