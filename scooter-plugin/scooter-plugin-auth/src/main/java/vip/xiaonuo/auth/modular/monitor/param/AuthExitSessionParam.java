
package vip.xiaonuo.auth.modular.monitor.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Session退出参数
 *
 * @author xuyuxiang
 * @date 2022/6/24 22:28
 */
@Getter
@Setter
public class AuthExitSessionParam {

    /** 用户id */
    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "userId不能为空")
    private String userId;
}
