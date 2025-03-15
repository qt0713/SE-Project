
package vip.xiaonuo.gen.modular.basic.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 菜单选择器参数
 *
 * @author yubaoshan
 * @date 2024/9/6 01:24
 **/
@Getter
@Setter
public class GenBasicSelectorMenuParam {

    /** 模块 */
    @Schema(description = "模块")
    @NotBlank(message = "module不能为空")
    private String module;
}
