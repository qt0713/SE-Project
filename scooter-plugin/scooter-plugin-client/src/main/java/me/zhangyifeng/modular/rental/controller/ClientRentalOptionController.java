package me.zhangyifeng.modular.rental.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import me.zhangyifeng.biz.modular.booking.service.BookingService;
import me.zhangyifeng.biz.modular.creditcard.entity.Creditcard;
import me.zhangyifeng.biz.modular.creditcard.service.CreditcardService;
import me.zhangyifeng.biz.modular.payment.entity.Payment;
import me.zhangyifeng.biz.modular.payment.service.PaymentService;
import me.zhangyifeng.biz.modular.rentalOption.entity.RentalOption;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionPageParam;
import me.zhangyifeng.biz.modular.rentalOption.service.RentalOptionService;
import me.zhangyifeng.biz.modular.scooter.entity.Scooter;
import me.zhangyifeng.biz.modular.scooter.service.ScooterService;
import me.zhangyifeng.modular.rental.param.RentParam;
import org.springframework.web.bind.annotation.*;
import vip.xiaonuo.auth.core.util.StpClientUtil;
import vip.xiaonuo.common.pojo.CommonResult;

import java.util.Date;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/9 15:57
 * @version: 1.0
 */
@RestController
@RequestMapping("/client/rental")
@Tag(name = "租赁选项")
public class ClientRentalOptionController {
    @Resource
    private RentalOptionService rentalOptionService;
    @Resource
    private BookingService bookingService;
    @Resource
    private PaymentService paymentService;
    @Resource
    private CreditcardService creditcardService;
    @Resource
    private ScooterService scooterService;

    /**
     * 获取RentalOption分页
     *
     * @author 张一风
     * @date 2025/03/07 22:56
     */
    @Operation(summary = "获取RentalOption分页")
    @GetMapping("/page")
    public CommonResult<Page<RentalOption>> page(RentalOptionPageParam rentalOptionPageParam) {
        return CommonResult.data(rentalOptionService.page(rentalOptionPageParam));
    }

    @Operation
    @PostMapping("/rent")
    public CommonResult<String> detail(@RequestBody RentParam rentParam) {
        Booking booking = new Booking();
        booking.setScooterId(rentParam.getScooterId());
        booking.setOptionId(rentParam.getRentalOptionId());
        booking.setStartTime(rentParam.getStartTime());
        if (rentParam.getRentalOptionId() == null) {
            return CommonResult.error("RentalOptionID cannot be empty");
        }
        if (rentParam.getScooterId() == null) {
            return CommonResult.error("ScooterID cannot be empty");
        }
        if (rentParam.getStartTime() == null) {
            return CommonResult.error("Start Time cannot be empty");
        }
        if (rentParam.getCreditCardId() == null) {
            return CommonResult.error("Credit Card cannot be empty");
        }
        if (rentParam.getStartTime().before(new Date())) {
            return CommonResult.error("Start Time cannot be in the past");
        }
        // 车辆
        Scooter scooter = new Scooter();
        scooter.setId(rentParam.getScooterId());
        if (scooterService.getById(rentParam.getScooterId()) == null) {
            return CommonResult.error("Scooter not found");
        }
        if (!scooterService.getById(rentParam.getScooterId()).getStatus().equalsIgnoreCase("AVAILABLE")) {
            return CommonResult.error("Scooter not available");
        }
        // 判断其他的预定是否有冲突
        QueryChainWrapper<Booking> queryChainWrapper = bookingService.query().eq("scooter_id", rentParam.getScooterId()).ge("start_time", rentParam.getStartTime()).le("start_time", new Date(rentParam.getStartTime().getTime() + 60 * 60 * 1000));
        if (queryChainWrapper.count() > 0) {
            return CommonResult.error("Scooter not available");
        }
        // 获取租用选项
        RentalOption rentalOption = rentalOptionService.getById(rentParam.getRentalOptionId());
        Date endTime = new Date(rentParam.getStartTime().getTime() + rentalOption.getDurationHours() * 60 * 1000);
        booking.setEndTime(endTime);
        booking.setTotalPrice(rentalOption.getBasePrice());
        //状态
        booking.setStatus("PENDING");
        booking.setUserId(StpClientUtil.getLoginIdAsString());
        booking.setBookingReference(String.valueOf(System.currentTimeMillis()));
        //保存预定
        bookingService.save(booking);
        //支付
        Payment payment = new Payment();
        payment.setBookingId(booking.getId());
        if (rentParam.getCreditCardId().equalsIgnoreCase("default")) {
            QueryChainWrapper<Creditcard> queryChainWrapper1 = creditcardService.query().eq("user_id", StpClientUtil.getLoginIdAsLong()).eq("is_default", 1);
            Creditcard creditcard = queryChainWrapper1.one();
            if (creditcard == null) {
                return CommonResult.error("Credit Card not found");
            }
            payment.setCardId(creditcard.getId());
        } else {
            if (creditcardService.getById(rentParam.getCreditCardId()) == null) {
                return CommonResult.error("Credit Card not found");
            }
            if (!creditcardService.getById(rentParam.getCreditCardId()).getUserId().equalsIgnoreCase(StpClientUtil.getLoginIdAsString())) {
                return CommonResult.error("Not your Credit Card ");
            }
            payment.setCardId(rentParam.getCreditCardId());
        }
        payment.setAmount(booking.getTotalPrice());
        payment.setPaymentMethod("CREDIT_CARD");
        payment.setStatus("COMPLETED");
        payment.setTransactionReference(String.valueOf(System.currentTimeMillis()));
        paymentService.save(payment);
        return CommonResult.ok();
    }

    @Operation
    @GetMapping("/extend")
    public CommonResult<String> extend(@RequestParam("scooterId") String scooterId, @RequestParam("creditCardId") String creditCardId, @RequestParam("rentalOptionId") String rentalOptionId) {
        Booking booking = bookingService.query().eq("scooter_id", scooterId).eq("status", "ACTIVE").one();
        if (booking == null) {
            return CommonResult.error("Booking not found");
        }
        if (!booking.getUserId().equalsIgnoreCase(StpClientUtil.getLoginIdAsString())) {
            return CommonResult.error("Not your booking");
        }
        if (!booking.getStatus().equalsIgnoreCase("ACTIVE")) {
            return CommonResult.error("Booking not active");
        }
        if (booking.getEndTime().before(new Date())) {
            return CommonResult.error("Booking already ended");
        }
        RentalOption rentalOption = rentalOptionService.getById(rentalOptionId);
        if (rentalOption == null) {
            return CommonResult.error("Rental Option not found");
        }
        // 更新预定
        Date endTime = new Date(booking.getEndTime().getTime() + rentalOption.getDurationHours() *60 * 60 * 1000);
        booking.setEndTime(endTime);
        booking.setTotalPrice(booking.getTotalPrice().add(rentalOption.getBasePrice()));
        bookingService.updateById(booking);
        // 添加交易
        Payment payment = new Payment();
        payment.setBookingId(booking.getId());
        if (creditCardId.equalsIgnoreCase("default")) {
            QueryChainWrapper<Creditcard> queryChainWrapper1 = creditcardService.query().eq("user_id", StpClientUtil.getLoginIdAsLong()).eq("is_default", 1);
            Creditcard creditcard = queryChainWrapper1.one();
            if (creditcard == null) {
                return CommonResult.error("Credit Card not found");
            }
            payment.setCardId(creditcard.getId());
        } else {
            if (creditcardService.getById(creditCardId) == null) {
                return CommonResult.error("Credit Card not found");
            }
            if (!creditcardService.getById(creditCardId).getUserId().equalsIgnoreCase(StpClientUtil.getLoginIdAsString())) {
                return CommonResult.error("Not your Credit Card ");
            }
            payment.setCardId(creditCardId);
        }
        payment.setAmount(rentalOption.getBasePrice());
        payment.setPaymentMethod("CREDIT_CARD");
        payment.setStatus("COMPLETED");
        payment.setTransactionReference(String.valueOf(System.currentTimeMillis()));
        paymentService.save(payment);
        return CommonResult.ok();
    }


    @Operation
    @GetMapping("/extendByBookingId")
    public CommonResult<String> extendByBookingId(@RequestParam("bookingId") String bookingId, @RequestParam("creditCardId") String creditCardId, @RequestParam("rentalOptionId") String rentalOptionId) {
        Booking booking = bookingService.getById(bookingId);
        if (booking == null) {
            return CommonResult.error("Booking not found");
        }
        if (!booking.getUserId().equalsIgnoreCase(StpClientUtil.getLoginIdAsString())) {
            return CommonResult.error("Not your booking");
        }
        if (booking.getEndTime().before(new Date())) {
            return CommonResult.error("Booking already ended");
        }
        RentalOption rentalOption = rentalOptionService.getById(rentalOptionId);
        if (rentalOption == null) {
            return CommonResult.error("Rental Option not found");
        }
        // 更新预定
        Date endTime = new Date(booking.getEndTime().getTime() + rentalOption.getDurationHours() * 60 * 60 * 1000);
        booking.setEndTime(endTime);
        booking.setTotalPrice(booking.getTotalPrice().add(rentalOption.getBasePrice()));
        bookingService.updateById(booking);
        // 添加交易
        Payment payment = new Payment();
        payment.setBookingId(booking.getId());
        if (creditCardId.equalsIgnoreCase("default")) {
            QueryChainWrapper<Creditcard> queryChainWrapper1 = creditcardService.query().eq("user_id", StpClientUtil.getLoginIdAsLong()).eq("is_default", 1);
            Creditcard creditcard = queryChainWrapper1.one();
            if (creditcard == null) {
                return CommonResult.error("Credit Card not found");
            }
            payment.setCardId(creditcard.getId());
        } else {
            if (creditcardService.getById(creditCardId) == null) {
                return CommonResult.error("Credit Card not found");
            }
            if (!creditcardService.getById(creditCardId).getUserId().equalsIgnoreCase(StpClientUtil.getLoginIdAsString())) {
                return CommonResult.error("Not your Credit Card ");
            }
            payment.setCardId(creditCardId);
        }
        payment.setAmount(rentalOption.getBasePrice());
        payment.setPaymentMethod("CREDIT_CARD");
        payment.setStatus("COMPLETED");
        payment.setTransactionReference(String.valueOf(System.currentTimeMillis()));
        paymentService.save(payment);
        return CommonResult.ok();
    }


    @Operation
    @GetMapping("/cancel")
    public CommonResult<String> cancel(@RequestParam("bookingId") String bookingId) {
        Booking booking = bookingService.getById(bookingId);
        if (booking == null) {
            return CommonResult.error("Booking not found");
        }
        if (!booking.getUserId().equalsIgnoreCase(StpClientUtil.getLoginIdAsString())) {
            return CommonResult.error("Not your booking");
        }
        if (!booking.getStatus().equalsIgnoreCase("PENDING")) {
            return CommonResult.error("Booking not pending");
        }
        booking.setStatus("CANCELLED");
        bookingService.updateById(booking);
        return CommonResult.ok();
    }
}
