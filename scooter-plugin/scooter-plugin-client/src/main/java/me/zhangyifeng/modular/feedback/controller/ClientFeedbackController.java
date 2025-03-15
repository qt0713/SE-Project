package me.zhangyifeng.modular.feedback.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import me.zhangyifeng.biz.modular.booking.service.BookingService;
import me.zhangyifeng.feedback.modular.feedback.entity.Feedback;
import me.zhangyifeng.feedback.modular.feedback.service.FeedbackService;
import me.zhangyifeng.modular.feedback.param.FeedbackSubmitParam;
import org.springframework.web.bind.annotation.*;
import vip.xiaonuo.auth.core.util.StpClientUtil;
import vip.xiaonuo.common.pojo.CommonResult;

import java.util.List;
import java.util.Map;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/10 12:17
 * @version: 1.0
 */

@RestController
@RequestMapping("/client/feedback")
@Tag(name = "反馈模块")
public class ClientFeedbackController {
    @Resource
    private FeedbackService feedbackService;
    @Resource
    private BookingService bookingService;

    @PostMapping("/submit")
    @Operation(summary = "提交反馈")
    public CommonResult<String> submit(@RequestBody FeedbackSubmitParam feedbackSubmitParam) {
        Feedback feedback = new Feedback();
        feedback.setStatus("OPEN");
        feedback.setFeedbackText(feedbackSubmitParam.getFeedbackText());
        feedback.setPriority(feedbackSubmitParam.getPriority());
        feedback.setUserId(StpClientUtil.getLoginIdAsString());
        // 通过scooterId找到booking
        List<Booking> bookings = bookingService.listByMap(Map.of("scooter_id", feedbackSubmitParam.getScooterId(), "status", "ACTIVE"));
        Booking booking = bookings.get(0);
        feedback.setScooterId(feedbackSubmitParam.getScooterId());
        feedbackService.save(feedback);
        // 故障相当于取消
        booking.setStatus("CANCELLED");
        bookingService.updateById(booking);
        return CommonResult.ok();
    }

    @GetMapping("/me")
    @Operation(summary = "获取我的反馈")
    public CommonResult<List<Feedback>> me() {
        return CommonResult.data(feedbackService.listByMap(Map.of("user_id", StpClientUtil.getLoginIdAsString())));
    }
}
