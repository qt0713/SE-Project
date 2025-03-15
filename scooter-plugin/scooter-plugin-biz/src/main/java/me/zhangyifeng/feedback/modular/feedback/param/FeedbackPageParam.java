
package me.zhangyifeng.feedback.modular.feedback.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Feedback查询参数
 *
 * @author 张一风
 * @date  2025/03/10 12:38
 **/
@Getter
@Setter
public class FeedbackPageParam {

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

    /** USER_ID */
    @Schema(description = "USER_ID")
    private String userId;

    /** FEEDBACK_TEXT */
    @Schema(description = "FEEDBACK_TEXT")
    private String feedbackText;

    /** PRIORITY */
    @Schema(description = "PRIORITY")
    private String priority;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

}
