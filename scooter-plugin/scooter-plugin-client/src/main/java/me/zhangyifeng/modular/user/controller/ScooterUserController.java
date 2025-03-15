package me.zhangyifeng.modular.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aliyun.teautil.Common;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jdk.jfr.Description;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import me.zhangyifeng.biz.modular.booking.service.BookingService;
import me.zhangyifeng.biz.modular.userDiscount.entity.UserDiscount;
import me.zhangyifeng.biz.modular.userDiscount.service.UserDiscountService;
import me.zhangyifeng.feedback.modular.feedback.entity.Feedback;
import me.zhangyifeng.feedback.modular.feedback.service.FeedbackService;
import me.zhangyifeng.modular.user.param.ClientUserEmailRegisterParam;
import me.zhangyifeng.modular.user.param.ClientUserRegisterParam;
import me.zhangyifeng.modular.user.param.ClientUserStatistics;
import me.zhangyifeng.modular.user.param.FilteredClientUser;
import org.apache.poi.hpsf.Decimal;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vip.xiaonuo.auth.core.util.StpClientUtil;
import vip.xiaonuo.client.modular.user.entity.ClientUser;
import vip.xiaonuo.client.modular.user.result.ClientLoginUser;
import vip.xiaonuo.client.modular.user.service.ClientUserService;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;

import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * @author: xiaofengs
 * @description :
 * @date: 2025/3/8 11:46
 * @version: 1.0
 */

@RestController
@Validated
@Tag(name = "Client User Controller")
public class ScooterUserController {

    @Resource
    private ClientUserService clientUserService;
    @Resource
    private UserDiscountService userDiscountService;
    @Resource
    private FeedbackService feedbackService;
    @Resource
    private BookingService bookingService;

    @PostMapping("/client/c/register")
    @Operation(summary = "C端用户注册")
    @CommonLog("C端用户")
    public CommonResult<String> register(@Valid @RequestBody ClientUserEmailRegisterParam clientUserEmailRegisterParam) {
        ClientUserRegisterParam clientUserRegisterParam = new ClientUserRegisterParam();
        BeanUtils.copyProperties(clientUserEmailRegisterParam, clientUserRegisterParam);

        try {
            clientUserService.register(clientUserRegisterParam);
        } catch (Exception e) {
            return CommonResult.error(e.getMessage());
        }
        return CommonResult.ok();
    }

    @GetMapping("/client/c/profile")
    @Operation(summary = "获取C端用户信息")
    @CommonLog("获取C端用户信息")
    public CommonResult<FilteredClientUser> profile() {
        ClientLoginUser userById = clientUserService.getUserById((String) StpClientUtil.getLoginId());
        FilteredClientUser filteredClientUser = new FilteredClientUser();
        BeanUtils.copyProperties(userById, filteredClientUser);
        return CommonResult.data(filteredClientUser);
    }

    @GetMapping("/client/c/sendEmailCaptcha")
    @Operation(summary = "发送邮箱验证码")
    @CommonLog("发送邮箱验证码")
    @Description("返回验证码请求号")
    public CommonResult<String> sendEmailCaptcha(@RequestParam("email") String email) {
        if (email == null || email.isEmpty()) {
            return CommonResult.error("邮箱不能为空");
        }
        String validCodeReqNo;
        try {
            validCodeReqNo = clientUserService.sendEmailCaptcha(email);
        } catch (Exception e) {
            return CommonResult.error(e.getMessage());
        }
        return CommonResult.data(validCodeReqNo);
    }

    @PostMapping("/client/c/editProfile")
    @Operation(summary = "编辑资料")
    @CommonLog("编辑用户资料")
    public CommonResult<FilteredClientUser> editProfile(@RequestBody FilteredClientUser filteredClientUser) {
        ClientUser clientUser = new ClientUser();
        BeanUtils.copyProperties(filteredClientUser, clientUser);
        clientUser.setId((String) StpClientUtil.getLoginId());
        clientUserService.updateById(clientUser);
        return CommonResult.data(filteredClientUser);
    }

    @GetMapping("/client/c/discount")
    @Operation(summary = "是否优惠")
    @CommonLog("是否优惠")
    public CommonResult<Object> discount() {
        UserDiscount userDiscount = userDiscountService.query().eq("user_id", StpClientUtil.getLoginIdAsLong()).one();
        if (userDiscount == null) {
            return CommonResult.data(-1);
        }
        return CommonResult.data(userDiscount.getDiscountPercentage());
    }

    @GetMapping("/client/c/statistics")
    @Operation(summary = "统计")
    public CommonResult<ClientUserStatistics> statistics() {
        ClientUserStatistics clientUserStatistics = new ClientUserStatistics();
        QueryChainWrapper<Booking> bookingQuery = bookingService.query();
        QueryChainWrapper<Feedback> feedbackQuery = feedbackService.query();
        Long feedbackCount = feedbackQuery.eq("user_id", StpClientUtil.getLoginIdAsLong()).count();
        Long bookingCount = bookingQuery.eq("user_id", StpClientUtil.getLoginIdAsLong()).count();
        // 计算完成的订单总金额
        BigDecimal amount = bookingService.getAmount(StpClientUtil.getLoginIdAsString());
        clientUserStatistics.setRecords(bookingCount);
        clientUserStatistics.setFeedbacks(feedbackCount);
        clientUserStatistics.setAmount(amount);
        return CommonResult.data(clientUserStatistics);
    }

}
