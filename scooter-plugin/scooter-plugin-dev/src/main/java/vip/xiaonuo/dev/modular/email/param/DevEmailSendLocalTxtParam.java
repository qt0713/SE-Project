
package vip.xiaonuo.dev.modular.email.param;

import cn.hutool.core.collection.CollectionUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.List;

/**
 * 邮件发送——本地TXT参数
 *
 * @author xuyuxiang
 * @date 2022/6/21 15:38
 **/
@Getter
@Setter
public class DevEmailSendLocalTxtParam {

    /** 接收人 */
    @Schema(description = "接收人邮箱地址，多个逗号拼接", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "receiveAccounts不能为空")
    private String receiveAccounts;

    /** 邮件主题 */
    @Schema(description = "邮件主题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "subject不能为空")
    private String subject;

    /** 邮件正文 */
    @Schema(description = "邮件正文", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "content不能为空")
    private String content;

    /** 附件列表 */
    @Schema(description = "附件列表", hidden = true)
    private List<File> files = CollectionUtil.newArrayList();
}
