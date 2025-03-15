
package vip.xiaonuo.dev.modular.log.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 日志清空参数
 *
 * @author xuyuxiang
 * @date 2022/9/6 13:16
 */
@Getter
@Setter
public class DevLogDeleteParam {

    /** 日志分类 */
    @Schema(description = "日志分类", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "category不能为空")
    private String category;
}
