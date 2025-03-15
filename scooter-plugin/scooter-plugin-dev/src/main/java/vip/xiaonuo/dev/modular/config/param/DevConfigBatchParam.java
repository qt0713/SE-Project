
package vip.xiaonuo.dev.modular.config.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 配置批量更新参数
 *
 * @author xuyuxiang
 * @date 2022/7/7 17:01
 **/
@Getter
@Setter
public class DevConfigBatchParam {

    /** 配置键 */
    @Schema(description = "配置键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "configKey不能为空")
    private String configKey;

    /** 配置值 */
    @Schema(description = "配置值", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "configValue不能为空")
    private String configValue;

}
