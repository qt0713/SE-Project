package me.zhangyifeng.modular.task;

import cn.hutool.cron.timingwheel.SystemTimer;
import cn.hutool.system.SystemUtil;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.zhangyifeng.biz.modular.booking.service.BookingService;
import me.zhangyifeng.biz.modular.payment.service.PaymentService;
import me.zhangyifeng.biz.modular.scooter.entity.Scooter;
import me.zhangyifeng.biz.modular.scooter.service.ScooterService;
import me.zhangyifeng.biz.modular.userDiscount.entity.UserDiscount;
import me.zhangyifeng.biz.modular.userDiscount.service.UserDiscountService;
import org.springframework.stereotype.Component;
import vip.xiaonuo.client.modular.user.service.ClientUserService;
import vip.xiaonuo.common.timer.CommonTimerTaskRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/10 9:00
 * @version: 1.0
 */
@Component
@Slf4j
public class UpdateUserDiscountJob implements CommonTimerTaskRunner {
    @Resource
    private ClientUserService clientUserService;
    @Resource
    private BookingService bookingService;
    @Resource
    private PaymentService paymentService;
    @Resource
    private UserDiscountService userDiscountService;

    @Override
    public void action(String extJson) {
        int[] n = {0};
        // 每周租用8个小时以上的用户有折扣，学生，老人有折扣
        clientUserService.list().forEach(clientUser -> {
            if (clientUser.getAge() != null && (Integer.parseInt(clientUser.getAge()) <= 18)) {
                UserDiscount userDiscount = userDiscountService.query().eq("user_id", clientUser.getId()).one();
                if (userDiscount == null) {
                    userDiscount = new UserDiscount();
                    userDiscount.setUserId(clientUser.getId());
                    userDiscount.setDiscountType("STUDENT");
                    userDiscount.setDiscountPercentage(BigDecimal.valueOf(0.8));
                    userDiscount.setValidFrom(new Date());
                    // 一直到18岁成年
                    userDiscount.setValidUntil(new Date((new Date().getTime() + Long.valueOf(18 * 365 * 24 * 60 * 60 * 1000))));
                    userDiscountService.save(userDiscount);
                    n[0] ++;
                }
            } else if (clientUser.getAge() != null && (Integer.parseInt(clientUser.getAge()) >= 60)) {
                UserDiscount userDiscount = userDiscountService.query().eq("user_id", clientUser.getId()).one();
                if (userDiscount == null) {
                    userDiscount = new UserDiscount();
                    userDiscount.setUserId(clientUser.getId());
                    userDiscount.setDiscountType("SENIOR");
                    userDiscount.setDiscountPercentage(BigDecimal.valueOf(0.7));
                    userDiscount.setValidFrom(new Date());
                    // 一直到100岁
                    userDiscount.setValidUntil(new Date((new Date().getTime() + Long.valueOf(100 * 365 * 24 * 60 * 60 * 1000))));
                    userDiscountService.save(userDiscount);
                    n[0] ++;

                }
            } else {
                // 每周租用8个小时以上的用户有折扣
                QueryChainWrapper queryChainWrapper = bookingService.query().eq("user_id", clientUser.getId());
                queryChainWrapper.ge("end_time", new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000));
                queryChainWrapper.select("sum(end_time - start_time) as total");
                queryChainWrapper.groupBy("user_id");
                queryChainWrapper.having("sum(end_time - start_time) > 8 * 60 * 60 * 1000");
                if (queryChainWrapper.count() > 0) {
                    UserDiscount userDiscount = userDiscountService.query().eq("user_id", clientUser.getId()).one();
                    if (userDiscount == null) {
                        userDiscount = new UserDiscount();
                        userDiscount.setUserId(clientUser.getId());
                        userDiscount.setDiscountType("FREQUENT_RENTER");
                        userDiscount.setDiscountPercentage(BigDecimal.valueOf(0.8));
                        userDiscount.setValidFrom(new Date());
                        // 一周后失效
                        userDiscount.setValidUntil(new Date((new Date().getTime() + Long.valueOf(7 * 24 * 60 * 60 * 1000))));
                        userDiscountService.save(userDiscount);

                    } else {
                        userDiscount.setDiscountPercentage(BigDecimal.valueOf(0.8));
                        userDiscount.setValidUntil(new Date((new Date().getTime() + Long.valueOf(7 * 24 * 60 * 60 * 1000))));
                        userDiscountService.updateById(userDiscount);
                    }
                    n[0] ++;
                }
            }

        });
        log.info(n[0]+"个用户折扣折扣");
    }
}
