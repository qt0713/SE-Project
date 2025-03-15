
package vip.xiaonuo.dev.modular.job.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import vip.xiaonuo.common.pojo.CommonEntity;

/**
 * 定时任务实体类
 *
 * @author xuyuxiang
 * @date 2022/8/5 10:38
 **/
@Getter
@Setter
@TableName("DEV_JOB")
public class DevJob extends CommonEntity {

    /** id */
    @Schema(description = "id")
    private String id;

    /** 名称 */
    @Schema(description = "名称")
    private String name;

    /** 编码 */
    @Schema(description = "编码")
    private String code;

    /** 分类 */
    @Schema(description = "分类")
    private String category;

    /** 任务类名 */
    @Schema(description = "任务类名")
    private String actionClass;

    /** cron表达式 */
    @Schema(description = "cron表达式")
    private String cronExpression;

    /** 任务状态 */
    @Schema(description = "任务状态")
    private String jobStatus;

    /** 排序码 */
    @Schema(description = "排序码")
    private Integer sortCode;

    /** 扩展信息 */
    @Schema(description = "扩展信息")
    @TableField(insertStrategy = FieldStrategy.IGNORED, updateStrategy = FieldStrategy.IGNORED)
    private String extJson;

}
