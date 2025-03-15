
package vip.xiaonuo.sys.modular.relation.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 关系实体
 *
 * @author xuyuxiang
 * @date 2022/4/21 16:13
 **/
@Getter
@Setter
@TableName("SYS_RELATION")
public class SysRelation{

    /** id */
    @Schema(description = "id")
    private String id;

    /** 对象id */
    @Schema(description = "对象id")
    private String objectId;

    /** 目标id */
    @Schema(description = "目标id")
    private String targetId;

    /** 分类 */
    @Schema(description = "分类")
    private String category;

    /** 扩展信息 */
    @Schema(description = "扩展信息")
    @TableField(insertStrategy = FieldStrategy.IGNORED, updateStrategy = FieldStrategy.IGNORED)
    private String extJson;
}
