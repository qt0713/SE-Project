
package vip.xiaonuo.dev.modular.job.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * 定时任务添加参数
 *
 * @author xuyuxiang
 * @date 2022/7/30 17:53
 */
@Getter
@Setter
public class DevJobAddParam {

    /** 名称 */
    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "name不能为空")
    private String name;

    /** 分类 */
    @Schema(description = "分类", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "category不能为空")
    private String category;

    /** 任务类名 */
    @Schema(description = "任务类名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "actionClass不能为空")
    private String actionClass;

    /** cron表达式 */
    @Schema(description = "cron表达式", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "cronExpression不能为空")
    private String cronExpression;

    /** 排序码 */
    @Schema(description = "排序码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "sortCode不能为空")
    private Integer sortCode;

    /** 扩展信息 */
    @Schema(description = "扩展信息")
    private String extJson;
}
