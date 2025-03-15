package me.zhangyifeng.modular.feedback.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/10 12:24
 * @version: 1.0
 */
@Getter
@Setter
public class FeedbackSubmitParam {
    @Schema(description = "反馈内容")
    @NotBlank(message = "反馈内容不能为空")
    private String feedbackText;
    @Schema(description = "优先权")
    @NotBlank(message = "优先权不能为空")
    private String priority;
    @Schema(description = "ScooterID")
    @NotBlank(message = "ScooterID不能为空")
    private String scooterId;

}
