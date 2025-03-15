
package vip.xiaonuo.sys.modular.resource.param.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * 菜单编辑参数
 *
 * @author xuyuxiang
 * @date 2022/7/27 18:40
 **/
@Getter
@Setter
public class SysMenuEditParam {

    /** id */
    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** 父id */
    @Schema(description = "父id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "parentId不能为空")
    private String parentId;

    /** 标题 */
    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "title不能为空")
    private String title;

    /** 菜单类型 */
    @Schema(description = "菜单类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "menuType不能为空")
    private String menuType;

    /** 模块 */
    @Schema(description = "模块", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "module不能为空")
    private String module;

    /** 路径 */
    @Schema(description = "路径", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "path不能为空")
    private String path;

    /** 排序码 */
    @Schema(description = "排序码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "sortCode不能为空")
    private Integer sortCode;

    /** 别名 */
    @Schema(description = "别名")
    private String name;

    /** 组件 */
    @Schema(description = "组件")
    private String component;

    /** 图标 */
    @Schema(description = "图标")
    private String icon;

    /** 是否可见 */
    @Schema(description = "是否可见")
    private String visible;

    /** 扩展信息 */
    @Schema(description = "扩展信息")
    private String extJson;
}
