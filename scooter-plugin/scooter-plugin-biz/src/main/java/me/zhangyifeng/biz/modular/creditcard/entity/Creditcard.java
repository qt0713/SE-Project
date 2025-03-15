
package me.zhangyifeng.biz.modular.creditcard.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * CreditCard实体
 *
 * @author 张一风
 * @date  2025/03/09 11:38
 **/
@Getter
@Setter
@TableName("CreditCard")
public class Creditcard {

    /** ID */
    @TableId
    @Schema(description = "ID")
    private String id;

    /** USER_ID */
    @Schema(description = "USER_ID")
    private String userId;

    /** CARD_NUMBER */
    @Schema(description = "CARD_NUMBER")
    private String cardNumber;

    /** CARD_HOLDER */
    @Schema(description = "CARD_HOLDER")
    private String cardHolder;

    /** EXPIRY_DATE */
    @Schema(description = "EXPIRY_DATE")
    private String expiryDate;

    /** CVV */
    @Schema(description = "CVV")
    private String cvv;

    /** IS_DEFAULT */
    @Schema(description = "IS_DEFAULT")
    private Integer isDefault;

    /** CREATE_TIME */
    @Schema(description = "CREATE_TIME")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** UPDATE_TIME */
    @Schema(description = "UPDATE_TIME")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
