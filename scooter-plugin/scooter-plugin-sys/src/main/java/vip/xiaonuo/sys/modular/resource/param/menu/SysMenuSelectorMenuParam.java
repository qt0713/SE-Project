
package vip.xiaonuo.sys.modular.resource.param.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 菜单选择器参数
 *
 * @author xuyuxiang
 * @date 2022/7/27 18:40
 **/
@Getter
@Setter
public class SysMenuSelectorMenuParam {

    /** 模块 */
    @Schema(description = "模块")
    private String module;
}
