package me.zhangyifeng.modular.user.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/8 12:01
 * @version: 1.0
 */

@Getter
@Setter
public class ClientUserRegisterParam {
    @Schema(description = "Account", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "account不能为空")
    private String account;

    @Schema(description = "Email")
    private String email;

    @Schema(description = "Phone")
    private String phone;

    @Schema(description = "Password", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "password不能为空")
    private String password;

    @Schema(description = "Valid Code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String validCode;

    @Schema(description = "Valid Code Request No ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String validCodeReqNo;
}
