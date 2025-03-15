
package vip.xiaonuo.biz.modular.notice.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 通知公告编辑参数
 *
 * @author yubaoshan
 * @date  2024/07/11 14:46
 **/
@Getter
@Setter
public class BizNoticeEditParam {

    /** 主键 */
    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "id不能为空")
    private String id;

    /** 标题 */
    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "title不能为空")
    private String title;

    /** 封面图 */
    @Schema(description = "封面图")
    private String image;

    /** 内容 */
    @Schema(description = "内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "content不能为空")
    private String content;

    /** 摘要 */
    @Schema(description = "摘要", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "digest不能为空")
    private String digest;

    /** 类型 */
    @Schema(description = "类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "type不能为空")
    private String type;

    /** 发布位置 */
    @Schema(description = "发布位置", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "place不能为空")
    private String place;

    /** 备注 */
    @Schema(description = "备注")
    private String remark;

    /** 排序码 */
    @Schema(description = "排序码")
    private Integer sortCode;
}
