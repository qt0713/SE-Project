package me.zhangyifeng.modular.rental.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/10 7:48
 * @version: 1.0
 */
@Getter
@Setter
public class RentParam {

    @Schema(description = "ScooterID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "ScooterID cannot be empty")
    private String scooterId;
    @Schema(description = "RentalOptionID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "RentalOptionID cannot be empty")
    private String rentalOptionId;
    @Schema(description = "StartTime", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "StartTime cannot be empty")
    private Date startTime;
    @Schema(description = "CreditCard", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "CreditCard cannot be empty")
    private String creditCardId;
}
