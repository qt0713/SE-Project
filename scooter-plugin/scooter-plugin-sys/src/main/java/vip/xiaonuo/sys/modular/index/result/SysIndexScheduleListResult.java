
package vip.xiaonuo.sys.modular.index.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 日程列表结果
 *
 * @author xuyuxiang
 * @date 2022/9/2 11:21
 */
@Getter
@Setter
public class SysIndexScheduleListResult {

    /** id */
    @Schema(description = "id")
    private String id;

    /** 用户id */
    @Schema(description = "用户id")
    private String scheduleUserId;

    /** 用户姓名 */
    @Schema(description = "用户姓名")
    private String scheduleUserName;

    /** 日程日期 */
    @Schema(description = "日程日期")
    private String scheduleDate;

    /** 日程时间 */
    @Schema(description = "日程时间")
    private String scheduleTime;

    /** 日程内容 */
    @Schema(description = "日程内容")
    private String scheduleContent;
}
