
package vip.xiaonuo.dev.modular.sms.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 短信发送——小诺参数
 *
 * @author xuyuxiang
 * @date 2022/7/31 15:21
 */
@Getter
@Setter
public class DevSmsSendXiaonuoParam {

    /** 手机号 */
    @Schema(description = "手机号，多个逗号拼接", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "phoneNumbers不能为空")
    private String phoneNumbers;

    /** 短信内容 */
    @Schema(description = "短信内容")
    private String message;

    /** 短信签名 */
    @Schema(description = "短信签名")
    private String signName;
}
