
package vip.xiaonuo.sys.modular.group.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

/**
 * 用户组Id参数
 *
 * @author yubaoshan
 * @date  2024/12/21 01:25
 **/
@Getter
@Setter
public class SysGroupIdParam {

    /** 主键 */
    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;
}
