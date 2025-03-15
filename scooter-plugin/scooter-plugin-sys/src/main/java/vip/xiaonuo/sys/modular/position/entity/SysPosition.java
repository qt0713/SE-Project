
package vip.xiaonuo.sys.modular.position.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import vip.xiaonuo.common.pojo.CommonEntity;

/**
 * 职位实体
 *
 * @author xuyuxiang
 * @date 2022/4/21 16:13
 **/
@Getter
@Setter
@TableName("SYS_POSITION")
public class SysPosition extends CommonEntity {

    /** id */
    @Schema(description = "id")
    private String id;

    /** 组织id */
    @Schema(description = "组织id")
    private String orgId;

    /** 名称 */
    @Schema(description = "名称")
    private String name;

    /** 编码 */
    @Schema(description = "编码")
    private String code;

    /** 分类 */
    @Schema(description = "分类")
    private String category;

    /** 排序码 */
    @Schema(description = "排序码")
    private Integer sortCode;

    /** 扩展信息 */
    @Schema(description = "扩展信息")
    @TableField(insertStrategy = FieldStrategy.IGNORED, updateStrategy = FieldStrategy.IGNORED)
    private String extJson;
}
