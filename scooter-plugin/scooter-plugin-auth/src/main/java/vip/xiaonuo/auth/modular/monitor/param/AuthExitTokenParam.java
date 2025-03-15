
package vip.xiaonuo.auth.modular.monitor.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Token退出参数
 *
 * @author xuyuxiang
 * @date 2022/6/24 22:28
 */
@Getter
@Setter
public class AuthExitTokenParam {

    /** token值 */
    @Schema(description = "token值", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "tokenValue不能为空")
    private String tokenValue;
}
