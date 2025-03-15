
package vip.xiaonuo.sys.modular.user.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 图片验证码结果
 *
 * @author xuyuxiang
 * @date 2022/7/8 9:28
 **/
@Getter
@Setter
public class SysUserPicValidCodeResult {

    /** 验证码图片，Base64 */
    @Schema(description = "验证码图片，Base64")
    private String validCodeBase64;

    /** 验证码请求号 */
    @Schema(description = "验证码请求号")
    private String validCodeReqNo;
}
