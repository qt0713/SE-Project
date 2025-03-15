package me.zhangyifeng.biz.modular.booking.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import me.zhangyifeng.biz.modular.booking.param.BookingAddParam;
import me.zhangyifeng.biz.modular.booking.param.BookingEditParam;
import me.zhangyifeng.biz.modular.booking.param.BookingIdParam;
import me.zhangyifeng.biz.modular.booking.param.BookingPageParam;
import me.zhangyifeng.biz.modular.booking.service.BookingService;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import vip.xiaonuo.common.annotation.CommonLog;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * booking控制器
 * 
 * @author 张一风
 * @date 2025/03/07 22:30
 */
@Tag(name = "booking控制器")
@RestController
@Validated
public class BookingController {

    @Resource
    private BookingService bookingService;

    /**
     * 获取booking分页
     * 
     * @author 张一风
     * @date 2025/03/07 22:30
     */
    @Operation(summary = "获取booking分页")
    @SaCheckPermission("/biz/booking/page")
    @GetMapping("/biz/booking/page")
    public CommonResult<Page<Booking>> page(BookingPageParam bookingPageParam) {
        return CommonResult.data(bookingService.page(bookingPageParam));
    }

    /**
     * 添加booking
     * 
     * @author 张一风
     * @date 2025/03/07 22:30
     */
    @Operation(summary = "添加booking")
    @CommonLog("添加booking")
    @SaCheckPermission("/biz/booking/add")
    @PostMapping("/biz/booking/add")
    public CommonResult<String> add(@RequestBody @Valid BookingAddParam bookingAddParam) {
        bookingService.add(bookingAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑booking
     * 
     * @author 张一风
     * @date 2025/03/07 22:30
     */
    @Operation(summary = "编辑booking")
    @CommonLog("编辑booking")
    @SaCheckPermission("/biz/booking/edit")
    @PostMapping("/biz/booking/edit")
    public CommonResult<String> edit(@RequestBody @Valid BookingEditParam bookingEditParam) {
        bookingService.edit(bookingEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除booking
     * 
     * @author 张一风
     * @date 2025/03/07 22:30
     */
    @Operation(summary = "删除booking")
    @CommonLog("删除booking")
    @SaCheckPermission("/biz/booking/delete")
    @PostMapping("/biz/booking/delete")
    public CommonResult<String> delete(
            @RequestBody @Valid @NotEmpty(message = "集合不能为空") List<BookingIdParam> bookingIdParamList) {
        bookingService.delete(bookingIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取booking详情
     * 
     * @author 张一风
     * @date 2025/03/07 22:30
     */
    @Operation(summary = "获取booking详情")
    @SaCheckPermission("/biz/booking/detail")
    @GetMapping("/biz/booking/detail")
    public CommonResult<Booking> detail(@Valid BookingIdParam bookingIdParam) {
        return CommonResult.data(bookingService.detail(bookingIdParam));
    }

    /**
     * 获取周收入按租赁选项统计
     * 
     * @author 张一风
     * @date 2025/03/17 14:30
     */
    @Operation(summary = "获取周收入按租赁选项统计")
    @SaCheckPermission("/biz/booking/stats/weekly-income-by-option")
    @GetMapping("/biz/booking/stats/weekly-income-by-option")
    public CommonResult<Map<String, Double>> getWeeklyIncomeByOption(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        // 调用service层获取租赁选项的周收入数据
        Map<String, Double> incomeByOption = bookingService.getWeeklyIncomeByOption(startDate, endDate);
        return CommonResult.data(incomeByOption);
    }

    /**
     * 获取一周内每日总收入统计
     * 
     * @author 张一风
     * @date 2025/03/17 14:30
     */
    @Operation(summary = "获取一周内每日总收入统计")
    @SaCheckPermission("/biz/booking/stats/daily-income-combined")
    @GetMapping("/biz/booking/stats/daily-income-combined")
    public CommonResult<List<Map<String, Object>>> getDailyIncomeCombined(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        // 调用service层获取每日总收入数据
        List<Map<String, Object>> dailyIncome = bookingService.getDailyIncomeCombined(startDate, endDate);
        return CommonResult.data(dailyIncome);
    }
}
