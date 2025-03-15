
package vip.xiaonuo.dev.modular.sms.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 短信发送——阿里云参数
 *
 * @author xuyuxiang
 * @date 2022/7/31 15:21
 */
@Getter
@Setter
public class DevSmsSendAliyunParam {

    /** 手机号 */
    @Schema(description = "手机号，多个逗号拼接", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "phoneNumbers不能为空")
    private String phoneNumbers;

    /** 模板编码 */
    @Schema(description = "短信服务控制台配置且审核通过的模板编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "templateCode不能为空")
    private String templateCode;

    /** 发送参数 */
    @Schema(description = "短信模板变量对应的实际值，JSON格式")
    private String templateParam;

    /** 短信签名 */
    @Schema(description = "短信服务控制台配置且审核通过的短信签名")
    private String signName;
}
