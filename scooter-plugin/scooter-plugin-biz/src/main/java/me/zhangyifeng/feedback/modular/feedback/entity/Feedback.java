
package me.zhangyifeng.feedback.modular.feedback.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Feedback实体
 *
 * @author 张一风
 * @date  2025/03/10 12:38
 **/
@Getter
@Setter
@TableName("Feedback")
public class Feedback {

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

    /** BOOKING_ID */
    @Schema(description = "BOOKING_ID")
    private String bookingId;

    /** FEEDBACK_TEXT */
    @Schema(description = "FEEDBACK_TEXT")
    private String feedbackText;

    /** PRIORITY */
    @Schema(description = "PRIORITY")
    private String priority;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

    /** CREATE_TIME */
    @Schema(description = "CREATE_TIME")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** UPDATE_TIME */
    @Schema(description = "UPDATE_TIME")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
