
package me.zhangyifeng.biz.modular.scooter.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Scooter查询参数
 *
 * @author 张一风
 * @date  2025/03/07 22:51
 **/
@Getter
@Setter
public class ScooterPageParam {

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

    /** 关键词 */
    @Schema(description = "关键词")
    private String searchKey;

    /** MODEL */
    @Schema(description = "MODEL")
    private String model;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

    /** BATTERY_LEVEL */
    @Schema(description = "BATTERY_LEVEL")
    private Integer batteryLevel;

    /** LAST_MAINTENANCE_DATE开始 */
    @Schema(description = "LAST_MAINTENANCE_DATE开始")
    private String startLastMaintenanceDate;

    /** LAST_MAINTENANCE_DATE结束 */
    @Schema(description = "LAST_MAINTENANCE_DATE结束")
    private String endLastMaintenanceDate;

}
