
package me.zhangyifeng.biz.modular.creditcard.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CreditCard查询参数
 *
 * @author 张一风
 * @date 2025/03/09 11:38
 **/
@Getter
@Setter
public class CreditcardPageParam {

    /**
     * 当前页
     */
    @Schema(description = "当前页码")
    private Integer current;

    /**
     * 每页条数
     */
    @Schema(description = "每页条数")
    private Integer size;

    /**
     * 排序字段
     */
    @Schema(description = "排序字段，字段驼峰名称，如：userName")
    private String sortField;

    /**
     * 排序方式
     */
    @Schema(description = "排序方式，升序：ASCEND；降序：DESCEND")
    private String sortOrder;

    /**
     * 关键词
     */
    @Schema(description = "关键词")
    private String searchKey;

    /**
     * USER_ID
     */
    @Schema(description = "USER_ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String userId;

    /**
     * CARD_HOLDER
     */
    @Schema(description = "CARD_HOLDER")
    private String cardHolder;

    /**
     * CREATE_TIME开始
     */
    @Schema(description = "CREATE_TIME开始")
    private String startCreateTime;

    /**
     * CREATE_TIME结束
     */
    @Schema(description = "CREATE_TIME结束")
    private String endCreateTime;

    /**
     * UPDATE_TIME开始
     */
    @Schema(description = "UPDATE_TIME开始")
    private String startUpdateTime;

    /**
     * UPDATE_TIME结束
     */
    @Schema(description = "UPDATE_TIME结束")
    private String endUpdateTime;

}
