
package vip.xiaonuo.sys.modular.role.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 角色授权用户参数
 *
 * @author xuyuxiang
 * @date 2022/7/27 15:05
 **/
@Getter
@Setter
public class SysRoleGrantUserParam {

    /** 角色id */
    @Schema(description = "角色id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** 授权用户信息 */
    @Schema(description = "授权用户信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "grantInfoList不能为空")
    private List<String> grantInfoList;
}
