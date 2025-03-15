
package vip.xiaonuo.sys.modular.group.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户组选择器参数
 *
 * @author yubaoshan
 * @date 2025/1/12 02:36
 **/
@Getter
@Setter
public class SysGroupSelectorParam {

    /** 当前页 */
    @Schema(description = "当前页码")
    private Integer current;

    /** 每页条数 */
    @Schema(description = "每页条数")
    private Integer size;

    /** 姓名关键词 */
    @Schema(description = "姓名关键词")
    private String searchKey;
}
