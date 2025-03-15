
package vip.xiaonuo.biz.modular.index.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 轮播图列表参数
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 **/
@Getter
@Setter
public class BizIndexSlideshowListParam {

    /** 位置" */
    @Schema(description = "位置")
    private String place;
}
