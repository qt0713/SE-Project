package me.zhangyifeng.biz.modular.booking.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import me.zhangyifeng.biz.modular.booking.param.BookingAddParam;
import me.zhangyifeng.biz.modular.booking.param.BookingEditParam;
import me.zhangyifeng.biz.modular.booking.param.BookingIdParam;
import me.zhangyifeng.biz.modular.booking.param.BookingPageParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * bookingService接口
 *
 * @author 张一风
 * @date  2025/03/07 22:30
 **/
public interface BookingService extends IService<Booking> {

    /**
     * 获取booking分页
     *
     * @author 张一风
     * @date  2025/03/07 22:30
     */
    Page<Booking> page(BookingPageParam bookingPageParam);

    /**
     * 添加booking
     *
     * @author 张一风
     * @date  2025/03/07 22:30
     */
    void add(BookingAddParam bookingAddParam);

    /**
     * 编辑booking
     *
     * @author 张一风
     * @date  2025/03/07 22:30
     */
    void edit(BookingEditParam bookingEditParam);

    /**
     * 删除booking
     *
     * @author 张一风
     * @date  2025/03/07 22:30
     */
    void delete(List<BookingIdParam> bookingIdParamList);

    /**
     * 获取booking详情
     *
     * @author 张一风
     * @date  2025/03/07 22:30
     */
    Booking detail(BookingIdParam bookingIdParam);

    /**
     * 获取booking详情
     *
     * @author 张一风
     * @date  2025/03/07 22:30
     **/
    Booking queryEntity(String id);

    BigDecimal getAmount(String loginIdAsString);

    /**
     * 获取周收入按租赁选项统计
     * 
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 各租赁选项的收入统计
     */
    Map<String, Double> getWeeklyIncomeByOption(LocalDate startDate, LocalDate endDate);
    
    /**
     * 获取一周内每日总收入统计
     * 
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 日期和对应的总收入列表
     */
    List<Map<String, Object>> getDailyIncomeCombined(LocalDate startDate, LocalDate endDate);
}
