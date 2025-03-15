
package vip.xiaonuo.sys.modular.user.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 编辑个人信息参数
 *
 * @author xuyuxiang
 * @date 2022/7/27 17:08
 **/
@Getter
@Setter
public class SysUserUpdateInfoParam {

    /** id */
    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** 姓名 */
    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "name不能为空")
    private String name;

    /** 手机 */
    @Schema(description = "手机")
    private String phone;

    /** 昵称 */
    @Schema(description = "昵称")
    private String nickname;

    /** 性别 */
    @Schema(description = "性别")
    private String gender;

    /** 出生日期 */
    @Schema(description = "出生日期")
    private String birthday;

    /** 邮箱 */
    @Schema(description = "邮箱")
    private String email;

    /** 签名 */
    @Schema(description = "签名，图片base64")
    private String signature;
}
