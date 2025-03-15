
package vip.xiaonuo.biz.modular.notice.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 通知公告Id参数
 *
 * @author yubaoshan
 * @date  2024/07/11 14:46
 **/
@Getter
@Setter
public class BizNoticeIdParam {

    /** 主键 */
    @Schema(description = "主键")
    @NotBlank(message = "id不能为空")
    private String id;
}
