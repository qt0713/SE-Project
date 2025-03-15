
package me.zhangyifeng.biz.modular.booking.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * booking查询参数
 *
 * @author 张一风
 * @date  2025/03/07 22:30
 **/
@Getter
@Setter
public class BookingPageParam {

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

    /** START_TIME开始 */
    @Schema(description = "START_TIME开始")
    private String startStartTime;

    /** START_TIME结束 */
    @Schema(description = "START_TIME结束")
    private String endStartTime;

    /** END_TIME开始 */
    @Schema(description = "END_TIME开始")
    private String startEndTime;

    /** END_TIME结束 */
    @Schema(description = "END_TIME结束")
    private String endEndTime;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

    /** BOOKING_REFERENCE */
    @Schema(description = "BOOKING_REFERENCE")
    private String bookingReference;

    /** CREATE_TIME开始 */
    @Schema(description = "CREATE_TIME开始")
    private String startCreateTime;

    /** CREATE_TIME结束 */
    @Schema(description = "CREATE_TIME结束")
    private String endCreateTime;

    /** UPDATE_TIME开始 */
    @Schema(description = "UPDATE_TIME开始")
    private String startUpdateTime;

    /** UPDATE_TIME结束 */
    @Schema(description = "UPDATE_TIME结束")
    private String endUpdateTime;

}
