
package vip.xiaonuo.sys.modular.user.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 职位选择器参数
 *
 * @author xuyuxiang
 * @date 2022/7/26 15:58
 **/
@Getter
@Setter
public class SysUserSelectorPositionParam {

    /** 当前页 */
    @Schema(description = "当前页码")
    private Integer current;

    /** 每页条数 */
    @Schema(description = "每页条数")
    private Integer size;

    /** 组织id */
    @Schema(description = "组织id")
    private String orgId;

    /** 名称关键词 */
    @Schema(description = "名称关键词")
    private String searchKey;
}
