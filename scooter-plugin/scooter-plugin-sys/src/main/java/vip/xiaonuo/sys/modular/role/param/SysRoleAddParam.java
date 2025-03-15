
package vip.xiaonuo.sys.modular.role.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色添加参数
 *
 * @author xuyuxiang
 * @date 2022/4/21 16:13
 **/
@Getter
@Setter
public class SysRoleAddParam {

    /** 名称 */
    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "name不能为空")
    private String name;

    /** 分类 */
    @Schema(description = "分类", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "category不能为空")
    private String category;

    /** 排序码 */
    @Schema(description = "排序码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "sortCode不能为空")
    private Integer sortCode;

    /** 组织id */
    @Schema(description = "组织id")
    private String orgId;

    /** 扩展JSON */
    @Schema(description = "扩展JSON")
    private String extJson;
}
