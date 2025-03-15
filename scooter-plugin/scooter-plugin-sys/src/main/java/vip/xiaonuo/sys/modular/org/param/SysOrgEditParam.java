
package vip.xiaonuo.sys.modular.org.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * 组织编辑参数
 *
 * @author xuyuxiang
 * @date 2022/4/21 16:13
 **/
@Getter
@Setter
public class SysOrgEditParam {

    /** id */
    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** 父id */
    @Schema(description = "父id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "parentId不能为空")
    private String parentId;

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

    /** 主管id */
    @Schema(description = "主管id")
    private String directorId;

    /** 扩展JSON */
    @Schema(description = "扩展JSON")
    private String extJson;
}
