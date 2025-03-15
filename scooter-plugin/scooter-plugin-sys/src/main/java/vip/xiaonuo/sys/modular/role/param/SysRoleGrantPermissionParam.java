
package vip.xiaonuo.sys.modular.role.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 角色授权权限参数
 *
 * @author xuyuxiang
 * @date 2022/7/27 15:05
 **/
@Getter
@Setter
public class SysRoleGrantPermissionParam {

    /** 角色id */
    @Schema(description = "角色id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** 授权权限信息 */
    @Valid
    @Schema(description = "授权权限信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "grantInfoList不能为空")
    private List<SysRoleGrantPermission> grantInfoList;

    /**
     * 角色授权权限类
     *
     * @author xuyuxiang
     * @date 2022/4/28 23:19
     */
    @Getter
    @Setter
    public static class SysRoleGrantPermission {

        /** 接口地址 */
        @Schema(description = "接口地址")
        @NotBlank(message = "apiUrl不能为空")
        private String apiUrl;

        /** 数据范围分类 */
        @Schema(description = "数据范围分类")
        @NotBlank(message = "scopeCategory不能为空")
        private String scopeCategory;

        /** 自定义范围组织id集合 */
        @Schema(description = "自定义范围组织id集合")
        @NotNull(message = "scopeDefineOrgIdList不能为空")
        private List<String> scopeDefineOrgIdList;
    }
}
