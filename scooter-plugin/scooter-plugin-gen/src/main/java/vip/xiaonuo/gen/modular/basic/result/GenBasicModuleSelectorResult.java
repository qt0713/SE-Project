
package vip.xiaonuo.gen.modular.basic.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 代码生成模块所需要用到的模块选择的结果
 *
 * @author yubaoshan
 * @date 2024/9/6 01:24
 **/
@Getter
@Setter
public class GenBasicModuleSelectorResult {

    /** id */
    @Schema(description = "id")
    private String id;

    /** 名称 */
    @Schema(description = "名称")
    private String name;
}
