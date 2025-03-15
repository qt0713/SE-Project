
package vip.xiaonuo.sys.modular.user.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户导出参数
 *
 * @author xuyuxiang
 * @date 2022/7/26 16:00
 **/
@Getter
@Setter
public class SysUserExportParam {

    /** 用户状态 */
    @Schema(description = "用户状态")
    private String userStatus;

    /** 账号、姓名、手机号关键词 */
    @Schema(description = "账号、姓名、手机号关键词")
    private String searchKey;

    /** 用户id集合 */
    @Schema(description = "用户id集合")
    private String userIds;
}
