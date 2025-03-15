
package vip.xiaonuo.dev.modular.message.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 站内信结果
 *
 * @author xuyuxiang
 * @date 2022/7/31 16:39
 */
@Getter
@Setter
public class DevMessageResult {

    /** id */
    @Schema(description = "id")
    private String id;

    /** 分类 */
    @Schema(description = "分类")
    private String category;

    /** 主题 */
    @Schema(description = "主题")
    private String subject;

    /** 正文 */
    @Schema(description = "正文")
    private String content;

    /** 扩展信息 */
    @Schema(description = "扩展信息")
    private String extJson;

    /** 接收信息集合 */
    @Schema(description = "接收信息集合")
    private List<DevReceiveInfo> receiveInfoList;

    /**
     * 接收信息类
     *
     * @author xuyuxiang
     * @date 2022/7/31 16:42
     */
    @Getter
    @Setter
    public static class DevReceiveInfo {

        /** 接收人ID */
        @Schema(description = "接收人ID")
        private String receiveUserId;

        /** 接收人姓名 */
        @Schema(description = "接收人姓名")
        private String receiveUserName;

        /** 是否已读 */
        @Schema(description = "是否已读")
        private Boolean read;
    }
}
