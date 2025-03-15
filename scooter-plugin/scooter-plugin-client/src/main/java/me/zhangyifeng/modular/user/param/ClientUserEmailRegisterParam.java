package me.zhangyifeng.modular.user.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/8 11:56
 * @version: 1.0
 */

@Getter
@Setter
public class ClientUserEmailRegisterParam {

    @Schema(description = "Account", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "account不能为空")
    private String account;

    @Schema(description = "Email", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "email不能为空")
    private String email;

    @Schema(description = "Password", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "password不能为空")
    private String password;

    @Schema(description = "Verification code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String validCode;

    @Schema(description = "Verification Code Request No", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String validCodeReqNo;


}
