package me.zhangyifeng.modular.booking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import me.zhangyifeng.biz.modular.booking.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.auth.core.util.StpClientUtil;
import vip.xiaonuo.common.pojo.CommonResult;

import java.util.List;
import java.util.Map;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/10 10:20
 * @version: 1.0
 */

@RestController
@RequestMapping("/client/booking")
@Tag(name = "预约模块")
public class ClientBookingController {
    @Resource
    private BookingService bookingService;

    @Operation(summary = "我的预约")
    @GetMapping("/me")
    public CommonResult<List<Booking>> my() {
        String userID = StpClientUtil.getLoginIdAsString();
        List<Booking> bookings = bookingService.listByMap(Map.of("user_id", userID));
        return CommonResult.data(bookings);
    }

}
