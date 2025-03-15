
package vip.xiaonuo.auth.modular.third.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 第三方登录授权结果
 *
 * @author xuyuxiang
 * @date 2022/7/8 20:39
 */
@Getter
@Setter
public class AuthThirdRenderResult {

    /** 授权地址 */
    @Schema(description = "授权地址")
    private String authorizeUrl;

    /** 状态码 */
    @Schema(description = "状态码")
    private String state;
}
