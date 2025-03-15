package me.zhangyifeng.modular.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import me.zhangyifeng.biz.modular.booking.service.BookingService;
import me.zhangyifeng.biz.modular.scooter.entity.Scooter;
import me.zhangyifeng.biz.modular.scooter.service.ScooterService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import vip.xiaonuo.common.timer.CommonTimerTaskRunner;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/10 8:34
 * @version: 1.0
 */
@Slf4j
@Component
public class UpdateScooterStatusJob implements CommonTimerTaskRunner {
    @Resource
    private ScooterService scooterService;
    @Resource
    private BookingService bookingService;
    @Override
    public void action(String extJson) {
        int[] n = {0};
        LambdaQueryWrapper<Booking> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(Booking::getStatus, "CANCELLED").ne(Booking::getStatus, "COMPLETED");
        bookingService.list(queryWrapper).forEach(booking -> {
            if (booking.getEndTime().getTime() >= System.currentTimeMillis() && booking.getStartTime().getTime() <= System.currentTimeMillis()) {
                booking.setStatus("ACTIVE");
                bookingService.updateById(booking);
                Scooter scooter = scooterService.getById(booking.getScooterId());
                scooter.setStatus("UNAVAILABLE");
                scooterService.updateById(scooter);
                n[0]++;
            } else if (booking.getEndTime().getTime() < System.currentTimeMillis()) {
                booking.setStatus("COMPLETED");
                bookingService.updateById(booking);
                Scooter scooter = scooterService.getById(booking.getScooterId());
                scooter.setStatus("AVAILABLE");
                scooterService.updateById(scooter);
                n[0]++;
            }
        });
        log.info("Scooter 更新"+n[0]+"辆");
    }
}

