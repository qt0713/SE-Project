
package vip.xiaonuo.sys.modular.org.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import vip.xiaonuo.common.pojo.CommonEntity;
import vip.xiaonuo.sys.modular.user.entity.SysUser;

/**
 * 组织实体
 *
 * @author xuyuxiang
 * @date 2022/4/21 16:13
 **/
@Getter
@Setter
@TableName("SYS_ORG")
public class SysOrg extends CommonEntity {

    /** id */
    @Schema(description = "id")
    private String id;

    /** 父id */
    @Schema(description = "父id")
    private String parentId;

    /** 主管id */
    @Schema(description = "主管id")
    @TableField(insertStrategy = FieldStrategy.IGNORED, updateStrategy = FieldStrategy.IGNORED)
    @Trans(type = TransType.SIMPLE, target = SysUser.class, fields = "name", alias = "director", ref = "directorName")
    private String directorId;

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
