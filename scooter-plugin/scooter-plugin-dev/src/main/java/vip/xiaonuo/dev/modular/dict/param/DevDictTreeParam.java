
package vip.xiaonuo.dev.modular.dict.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 字典树参数
 *
 * @author xuyuxiang
 * @date 2022/7/30 21:49
 */
@Getter
@Setter
public class DevDictTreeParam {

    /** 字典分类 */
    @Schema(description = "字典分类")
    private String category;
}
