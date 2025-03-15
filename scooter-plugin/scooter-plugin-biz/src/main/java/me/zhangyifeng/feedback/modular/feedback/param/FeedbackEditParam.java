
package me.zhangyifeng.feedback.modular.feedback.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Feedback编辑参数
 *
 * @author 张一风
 * @date  2025/03/10 12:38
 **/
@Getter
@Setter
public class FeedbackEditParam {

    /** ID */
    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
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

}
