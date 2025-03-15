
package me.zhangyifeng.biz.modular.payment.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Payment实体
 *
 * @author 张一风
 * @date  2025/03/07 23:02
 **/
@Getter
@Setter
@TableName("Payment")
public class Payment {

    /** ID */
    @TableId
    @Schema(description = "ID")
    private String id;

    /** BOOKING_ID */
    @Schema(description = "BOOKING_ID")
    private String bookingId;

    /** AMOUNT */
    @Schema(description = "AMOUNT")
    private BigDecimal amount;

    /** PAYMENT_METHOD */
    @Schema(description = "PAYMENT_METHOD")
    private String paymentMethod;

    /** CARD_ID */
    @Schema(description = "CARD_ID")
    private String cardId;

    /** TRANSACTION_REFERENCE */
    @Schema(description = "TRANSACTION_REFERENCE")
    private String transactionReference;

    /** STATUS */
    @Schema(description = "STATUS")
    private String status;

    /** CREATE_TIME */
    @Schema(description = "CREATE_TIME")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
