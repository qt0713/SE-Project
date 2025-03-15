
package vip.xiaonuo.gen.modular.config.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import vip.xiaonuo.common.pojo.CommonEntity;

/**
 * 代码生成详细配置
 *
 * @author yubaoshan
 * @date 2022/10/25 22:33
 **/
@Getter
@Setter
@TableName("GEN_CONFIG")
public class GenConfig extends CommonEntity {

    /** id */
    @Schema(description = "id")
    private String id;

    /** 基础ID */
    @Schema(description = "基础ID")
    private String basicId;

    /** 是否主键 */
    @Schema(description = "是否主键")
    private String isTableKey;

    /** 字段 */
    @Schema(description = "字段")
    private String fieldName;

    /** 注释 */
    @Schema(description = "注释")
    private String fieldRemark;

    /** 类型 */
    @Schema(description = "类型")
    private String fieldType;

    /** 实体类型 */
    @Schema(description = "实体类型")
    private String fieldJavaType;

    /** 作用类型 */
    @Schema(description = "作用类型")
    private String effectType;

    /** 字典 */
    @Schema(description = "字典")
    private String dictTypeCode;

    /** 列表显示 */
    @Schema(description = "列表显示")
    private String whetherTable;

    /** 列省略 */
    @Schema(description = "列省略")
    private String whetherRetract;

    /** 增改 */
    @Schema(description = "增改")
    private String whetherAddUpdate;

    /** 必填 */
    @Schema(description = "必填")
    private String whetherRequired;

    /** 查询 */
    @Schema(description = "查询")
    private String queryWhether;

    /** 查询方式 */
    @Schema(description = "查询方式")
    private String queryType;

    /** 排序 */
    @Schema(description = "排序")
    private Integer sortCode;
}
