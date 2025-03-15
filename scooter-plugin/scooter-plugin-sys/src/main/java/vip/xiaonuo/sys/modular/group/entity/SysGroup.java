
package vip.xiaonuo.sys.modular.group.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import vip.xiaonuo.common.pojo.CommonEntity;


/**
 * 用户组实体
 *
 * @author yubaoshan
 * @date  2024/12/21 01:25
 **/
@Getter
@Setter
@TableName("SYS_GROUP")
public class SysGroup extends CommonEntity {

    /** 主键 */
    @TableId
    @Schema(description = "主键")
    private String id;

    /** 名称 */
    @Schema(description = "名称")
    private String name;

    /** 备注 */
    @Schema(description = "备注")
    private String remark;

    /** 排序码 */
    @Schema(description = "排序码")
    private Integer sortCode;

    /** 扩展信息 */
    @Schema(description = "扩展信息")
    private String extJson;
}
