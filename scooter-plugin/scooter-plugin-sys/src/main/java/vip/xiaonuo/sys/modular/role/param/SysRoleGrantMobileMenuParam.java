
package vip.xiaonuo.sys.modular.role.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 角色授权移动端菜单参数
 *
 * @author xuyuxiang
 * @date 2022/7/27 15:05
 **/
@Getter
@Setter
public class SysRoleGrantMobileMenuParam {

    /** 角色id */
    @Schema(description = "角色id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** 授权移动端菜单信息 */
    @Valid
    @Schema(description = "授权移动端菜单信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "grantInfoList不能为空")
    private List<SysRoleGrantMobileMenu> grantInfoList;

    /**
     * 角色授权移动端菜单类
     *
     * @author xuyuxiang
     * @date 2022/4/28 23:19
     */
    @Getter
    @Setter
    public static class SysRoleGrantMobileMenu {

        /** 菜单id */
        @Schema(description = "菜单id")
        @NotBlank(message = "menuId不能为空")
        private String menuId;

        /** 按钮id集合 */
        @Schema(description = "按钮id集合")
        @NotNull(message = "buttonInfo不能为空")
        private List<String> buttonInfo;
    }
}
