
package vip.xiaonuo.sys.modular.user.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户id集合参数
 *
 * @author xuyuxiang
 * @date 2022/4/21 16:13
 **/
@Getter
@Setter
public class SysUserIdListParam {

    /** id集合 */
    @Schema(description = "id集合", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "idList不能为空")
    private List<String> idList;
}
