
package vip.xiaonuo.dev.modular.log.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 访问日志饼状图数据结果
 *
 * @author xuyuxiang
 * @date 2022/9/4 21:14
 */
@Getter
@Setter
public class DevLogVisPieChartDataResult {

    /** 类型 */
    @Schema(description = "类型")
    private String type;

    /** 数量 */
    @Schema(description = "数量")
    private Long value;
}
