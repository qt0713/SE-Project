
package vip.xiaonuo.mobile.modular.resource.param.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 移动端菜单tree查询参数
 *
 * @author yubaoshan
 * @date  2023/01/28 22:42
 **/
@Getter
@Setter
public class MobileMenuTreeParam {

    /** 关键词 */
    @Schema(description = "关键词")
    private String searchKey;

    /** 模块 */
    @Schema(description = "模块")
    private String module;

}
