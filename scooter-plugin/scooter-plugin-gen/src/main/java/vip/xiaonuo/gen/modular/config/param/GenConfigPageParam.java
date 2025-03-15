
package vip.xiaonuo.gen.modular.config.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 代码生成详细配置查询参数
 *
 * @author yubaoshan
 * @date 2022/10/25 22:33
 */
@Getter
@Setter
public class GenConfigPageParam {

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

    /** 基础ID */
    @Schema(description = "基础ID")
    @NotBlank(message = "basicId不能为空")
    private String basicId;
}
