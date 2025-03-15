
package vip.xiaonuo.dev.modular.dict.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 字典Id参数
 *
 * @author xuyuxiang
 * @date 2022/7/30 21:48
 */
@Getter
@Setter
public class DevDictIdParam {

    /** id */
    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;
}
