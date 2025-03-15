
package vip.xiaonuo.dev.modular.file.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 文件列表参数
 *
 * @author yubaoshan
 * @date 2024/6/9 23:52
 */
@Getter
@Setter
public class DevFileUrlListParam {

    /** 文件路径集合 */
    @Schema(description = "文件路径集合")
    @NotNull(message = "urlList不能为空")
    private List<String> urlList;
}
