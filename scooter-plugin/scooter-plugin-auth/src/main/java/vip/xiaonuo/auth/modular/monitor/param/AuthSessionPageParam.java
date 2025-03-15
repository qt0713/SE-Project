
package vip.xiaonuo.auth.modular.monitor.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 会话查询参数
 *
 * @author xuyuxiang
 * @date 2022/7/28 14:48
 **/
@Getter
@Setter
public class AuthSessionPageParam {

    /** 用户id */
    @Schema(description = "用户id")
    private String userId;
}
