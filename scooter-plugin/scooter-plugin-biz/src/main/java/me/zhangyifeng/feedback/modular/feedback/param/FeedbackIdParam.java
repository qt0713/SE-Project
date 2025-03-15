
package me.zhangyifeng.feedback.modular.feedback.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

/**
 * FeedbackId参数
 *
 * @author 张一风
 * @date  2025/03/10 12:38
 **/
@Getter
@Setter
public class FeedbackIdParam {

    /** ID */
    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;
}
