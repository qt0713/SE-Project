
package vip.xiaonuo.dev.api;

/**
 * 短信API
 *
 * @author xuyuxiang
 * @date 2022/6/22 15:22
 **/
public interface DevSmsApi {

    /* =========阿里云短信========= */

    /**
     * 发送短信
     *
     * @param phoneNumbers 手机号码，支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。
     *                     上限为1000个手机号码。批量调用相对于单条调用及时性稍有延迟。
     * @param signName 短信服务控制台配置且审核通过的短信签名，为空则使用默认签名
     * @param templateCode 短信服务控制台配置且审核通过的模板编码
     * @param templateParam 短信模板变量对应的实际值，JSON格式。支持传入多个参数，示例：{"name":"张三","number":"15038****76"}
     * @author xuyuxiang
     * @date 2022/2/24 13:42
     **/
    void sendSmsAliyun(String phoneNumbers, String signName, String templateCode, String templateParam);

    /* =========腾讯云短信========= */

    /**
     * 发送短信
     *
     * @param sdkAppId 短信 SdkAppId，在 短信控制台 添加应用后生成的实际 SdkAppId，示例如1400006666。
     *                 可前往 [短信控制台](https://console.cloud.tencent.com/smsv2/app-manage) 查看
     * @param phoneNumbers 手机号码，支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。
     *                     上限为1000个手机号码。批量调用相对于单条调用及时性稍有延迟。
     * @param signName 短信服务控制台配置且审核通过的短信签名，为空则使用默认签名
     * @param templateCode 短信服务控制台配置且审核通过的模板编码
     * @param templateParam 短信模板变量对应的顺序。支持传入多个参数，逗号拼接，示例："张三,15038****76,进行中"}
     * @author xuyuxiang
     * @date 2022/2/24 13:42
     **/
    void sendSmsTencent(String sdkAppId, String phoneNumbers, String signName, String templateCode, String templateParam);

    /* =========小诺短信========= */

    /**
     * 发送短信
     *
     * @param phoneNumbers 手机号码，支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。
     * @param signName 短信签名，为空则使用默认签名
     * @param message 短信内容
     * @author xuyuxiang
     * @date 2022/2/24 13:42
     **/
    void sendSmsXiaonuo(String phoneNumbers, String signName, String message);
}
