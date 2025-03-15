
package vip.xiaonuo.dev.modular.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import vip.xiaonuo.common.pojo.CommonEntity;

/**
 * 短信实体
 *
 * @author xuyuxiang
 * @date 2022/2/23 18:27
 **/
@Getter
@Setter
@TableName("DEV_SMS")
public class DevSms extends CommonEntity {

    /** id */
    @Schema(description = "id")
    private String id;

    /** 短信引擎 */
    @Schema(description = "短信引擎")
    private String engine;

    /** 手机号 */
    @Schema(description = "手机号")
    private String phoneNumbers;

    /** 短信签名 */
    @Schema(description = "短信签名")
    private String signName;

    /** 模板编码 */
    @Schema(description = "模板编码")
    private String templateCode;

    /** 发送参数 */
    @Schema(description = "发送参数")
    private String templateParam;

    /** 回执信息 */
    @Schema(description = "回执信息")
    private String receiptInfo;

    /** 扩展信息 */
    @Schema(description = "扩展信息")
    private String extJson;
}
