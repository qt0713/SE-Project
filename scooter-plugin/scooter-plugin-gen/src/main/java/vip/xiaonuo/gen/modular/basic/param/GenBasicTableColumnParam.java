
package vip.xiaonuo.gen.modular.basic.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 数据源库字段列表参数
 *
 * @author xuyuxiang
 * @date 2022/7/29 9:59
 */
@Getter
@Setter
public class GenBasicTableColumnParam {

    /** 表名称 */
    @Schema(description = "表名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "表名称不能为空")
    private String tableName;
}
