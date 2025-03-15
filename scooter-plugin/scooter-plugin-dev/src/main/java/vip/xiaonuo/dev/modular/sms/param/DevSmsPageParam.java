
package vip.xiaonuo.dev.modular.sms.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 短信查询参数
 *
 * @author xuyuxiang
 * @date 2022/7/31 15:26
 */
@Getter
@Setter
public class DevSmsPageParam {

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

    /** 短信引擎 */
    @Schema(description = "短信引擎")
    private String engine;

    /** 手机号关键词 */
    @Schema(description = "手机号关键词")
    private String searchKey;
}
