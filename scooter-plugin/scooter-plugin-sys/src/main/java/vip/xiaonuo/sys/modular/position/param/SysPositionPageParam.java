
package vip.xiaonuo.sys.modular.position.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 职位查询参数
 *
 * @author xuyuxiang
 * @date 2022/4/21 16:13
 **/
@Getter
@Setter
public class SysPositionPageParam {

    /** 当前页 */
    @Schema(description = "当前页码")
    private Integer current;

    /** 每页条数 */
    @Schema(description = "每页条数")
    private Integer size;

    /** 排序字段 */
    @Schema(description = "排序字段，字段驼峰名称，如：userName")
    private String sortField;

    /** 排序方式 */
    @Schema(description = "排序方式，升序：ASCEND；降序：DESCEND")
    private String sortOrder;

    /** 组织id */
    @Schema(description = "组织id")
    private String orgId;

    /** 职位分类 */
    @Schema(description = "职位分类")
    private String category;

    /** 名称关键词 */
    @Schema(description = "名称关键词")
    private String searchKey;
}
