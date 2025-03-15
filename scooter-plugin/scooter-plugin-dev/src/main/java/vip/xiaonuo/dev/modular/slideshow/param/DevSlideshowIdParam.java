
package vip.xiaonuo.dev.modular.slideshow.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 轮播图Id参数
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 **/
@Getter
@Setter
public class DevSlideshowIdParam {

    /** 主键 */
    @Schema(description = "主键")
    @NotBlank(message = "id不能为空")
    private String id;
}
