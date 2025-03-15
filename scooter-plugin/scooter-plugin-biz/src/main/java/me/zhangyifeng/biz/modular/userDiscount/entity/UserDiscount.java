
package me.zhangyifeng.biz.modular.userDiscount.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * UserDiscount实体
 *
 * @author 张一风
 * @date  2025/03/07 23:09
 **/
@Getter
@Setter
@TableName("UserDiscount")
public class UserDiscount {

    /** ID */
    @TableId
    @Schema(description = "ID")
    private String id;

    /** USER_ID */
    @Schema(description = "USER_ID")
    private String userId;

    /** DISCOUNT_TYPE */
    @Schema(description = "DISCOUNT_TYPE")
    private String discountType;

    /** DISCOUNT_PERCENTAGE */
    @Schema(description = "DISCOUNT_PERCENTAGE")
    private BigDecimal discountPercentage;

    /** VALID_FROM */
    @Schema(description = "VALID_FROM")
    private Date validFrom;

    /** VALID_UNTIL */
    @Schema(description = "VALID_UNTIL")
    private Date validUntil;

    /** PROOF_DOCUMENT */
    @Schema(description = "PROOF_DOCUMENT")
    private String proofDocument;

    /** CREATE_TIME */
    @Schema(description = "CREATE_TIME")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** UPDATE_TIME */
    @Schema(description = "UPDATE_TIME")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
