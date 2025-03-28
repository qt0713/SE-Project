
package vip.xiaonuo.dev.modular.email.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;
import vip.xiaonuo.dev.modular.email.entity.DevEmail;
import vip.xiaonuo.dev.modular.email.param.*;
import vip.xiaonuo.dev.modular.email.service.DevEmailService;

import java.util.List;

/**
 * 邮件控制器
 *
 * @author xuyuxiang
 * @date 2022/2/23 18:26
 **/
@Tag(name = "邮件控制器")
@RestController
@Validated
public class DevEmailController {

    @Resource
    private DevEmailService devEmailService;

    /**
     * 发送邮件——本地TXT
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "发送本地文本邮件")
    @CommonLog("发送本地文本邮件")
    @PostMapping("/dev/email/sendLocalTxt")
    public CommonResult<String> sendLocal(@RequestBody @Valid DevEmailSendLocalTxtParam devEmailSendLocalTxtParam) {
        devEmailService.sendLocal(devEmailSendLocalTxtParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——本地HTML
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "发送本地HTML邮件")
    @CommonLog("发送本地HTML邮件")
    @PostMapping("/dev/email/sendLocalHtml")
    public CommonResult<String> sendLocal(@RequestBody @Valid DevEmailSendLocalHtmlParam devEmailSendLocalHtmlParam) {
        devEmailService.sendLocal(devEmailSendLocalHtmlParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——阿里云TXT
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "发送阿里云文本邮件")
    @CommonLog("发送阿里云文本邮件")
    @PostMapping("/dev/email/sendAliyunTxt")
    public CommonResult<String> sendAliyun(@RequestBody @Valid DevEmailSendAliyunTxtParam devEmailSendAliyunTxtParam) {
        devEmailService.sendAliyun(devEmailSendAliyunTxtParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——阿里云HTML
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "发送阿里云HTML邮件")
    @CommonLog("发送阿里云HTML邮件")
    @PostMapping("/dev/email/sendAliyunHtml")
    public CommonResult<String> sendAliyun(@RequestBody @Valid DevEmailSendAliyunHtmlParam devEmailSendAliyunHtmlParam) {
        devEmailService.sendAliyun(devEmailSendAliyunHtmlParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——阿里云TMP
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "发送阿里云模板邮件")
    @CommonLog("发送阿里云模板邮件")
    @PostMapping("/dev/email/sendAliyunTmp")
    public CommonResult<String> sendAliyun(@RequestBody @Valid DevEmailSendAliyunTmpParam devEmailSendAliyunTmpParam) {
        devEmailService.sendAliyun(devEmailSendAliyunTmpParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——腾讯云TXT
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "发送腾讯云文本邮件")
    @CommonLog("发送腾讯云文本邮件")
    @PostMapping("/dev/email/sendTencentTxt")
    public CommonResult<String> sendTencent(@RequestBody @Valid DevEmailSendTencentTxtParam devEmailSendTencentTxtParam) {
        devEmailService.sendTencent(devEmailSendTencentTxtParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——腾讯云HTML
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "发送腾讯云HTML邮件")
    @CommonLog("发送腾讯云HTML邮件")
    @PostMapping("/dev/email/sentTencentHtml")
    public CommonResult<String> sendTencent(@RequestBody @Valid DevEmailSendTencentHtmlParam devEmailSendTencentHtmlParam) {
        devEmailService.sendTencent(devEmailSendTencentHtmlParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——腾讯云TMP
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "发送腾讯云模板邮件")
    @CommonLog("发送腾讯云模板邮件")
    @PostMapping("/dev/email/sentTencentTmp")
    public CommonResult<String> sendTencent(@RequestBody @Valid DevEmailSendTencentTmpParam devEmailSendTencentTmpParam) {
        devEmailService.sendTencent(devEmailSendTencentTmpParam);
        return CommonResult.ok();
    }

    /**
     * 获取邮件分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取邮件分页")
    @GetMapping("/dev/email/page")
    public CommonResult<Page<DevEmail>> page(DevEmailPageParam devEmailPageParam) {
        return CommonResult.data(devEmailService.page(devEmailPageParam));
    }

    /**
     * 删除邮件
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "删除邮件")
    @CommonLog("删除邮件")
    @PostMapping("/dev/email/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                               List<DevEmailIdParam> devEmailIdParamList) {
        devEmailService.delete(devEmailIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取邮件详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取邮件详情")
    @GetMapping("/dev/email/detail")
    public CommonResult<DevEmail> detail(@Valid DevEmailIdParam devEmailIdParam) {
        return CommonResult.data(devEmailService.detail(devEmailIdParam));
    }
}
