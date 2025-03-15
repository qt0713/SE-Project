
package vip.xiaonuo.sys.modular.role.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 角色拥有的权限结果
 *
 * @author xuyuxiang
 * @date 2022/7/27 15:08
 **/
@Getter
@Setter
public class SysRoleOwnPermissionResult {

    /** 角色id */
    @Schema(description = "角色id")
    private String id;

    /** 已授权权限信息 */
    @Schema(description = "已授权权限信息")
    private List<SysRoleOwnPermission> grantInfoList;

    /**
     * 角色拥有资源类
     *
     * @author xuyuxiang
     * @date 2022/4/28 23:19
     */
    @Getter
    @Setter
    public static class SysRoleOwnPermission {

        /** 菜单id */
        @Schema(description = "接口地址")
        private String apiUrl;

        /** 数据范围分类 */
        @Schema(description = "数据范围分类")
        private String scopeCategory;

        /** 自定义范围组织id集合 */
        @Schema(description = "自定义范围组织id集合")
        private List<String> scopeDefineOrgIdList;

    }
}
