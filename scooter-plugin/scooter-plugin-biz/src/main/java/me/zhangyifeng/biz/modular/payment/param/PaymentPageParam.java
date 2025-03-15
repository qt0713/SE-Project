
package me.zhangyifeng.biz.modular.payment.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Payment查询参数
 *
 * @author 张一风
 * @date  2025/03/07 23:02
 **/
@Getter
@Setter
public class PaymentPageParam {

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

    /** PAYMENT_METHOD */
    @Schema(description = "PAYMENT_METHOD")
    private String paymentMethod;

    /** TRANSACTION_REFERENCE */
    @Schema(description = "TRANSACTION_REFERENCE")
    private String transactionReference;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

    /** CREATE_TIME开始 */
    @Schema(description = "CREATE_TIME开始")
    private String startCreateTime;

    /** CREATE_TIME结束 */
    @Schema(description = "CREATE_TIME结束")
    private String endCreateTime;

}
