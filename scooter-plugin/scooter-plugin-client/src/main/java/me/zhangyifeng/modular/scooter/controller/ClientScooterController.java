package me.zhangyifeng.modular.scooter.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import me.zhangyifeng.biz.modular.booking.service.BookingService;
import me.zhangyifeng.biz.modular.scooter.entity.Scooter;
import me.zhangyifeng.biz.modular.scooter.param.ScooterPageParam;
import me.zhangyifeng.biz.modular.scooter.service.ScooterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.auth.core.util.StpClientUtil;
import vip.xiaonuo.common.pojo.CommonResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/9 14:21
 * @version: 1.0
 */

@RestController
@RequestMapping("/client/scooter")
@Tag(name = "租车模块")
public class ClientScooterController {
    @Resource
    private ScooterService scooterService;
    @Resource
    private BookingService bookingService;

    /**
     * 获取Scooter分页
     *
     * @author 张一风
     * @date 2025/03/07 22:51
     */
    @Operation(summary = "获取Scooter分页")
    @GetMapping("/page")
    public CommonResult<Page<Scooter>> page(ScooterPageParam scooterPageParam) {
        return CommonResult.data(scooterService.page(scooterPageParam));
    }

    @Operation(summary = "Scooter Info")
    @GetMapping("/detail")
    public CommonResult<Scooter> detail(String id) {
        return CommonResult.data(scooterService.getById(id));
    }

    @Operation(summary = "Current Scooter ")
    @GetMapping("/current")
    public CommonResult<List<Scooter>> current() {
        // 获取用户正在租用的车辆
        String userId = StpClientUtil.getLoginIdAsString();
        List<Scooter> scooters = new ArrayList<>();
        bookingService.query().eq("user_id", userId).eq("status", "ACTIVE").list().forEach(
                booking -> {
                    Scooter scooter = scooterService.getById(booking.getScooterId());
                    scooters.add(scooter);
                }
        );

        return CommonResult.data(scooters);
    }

}
