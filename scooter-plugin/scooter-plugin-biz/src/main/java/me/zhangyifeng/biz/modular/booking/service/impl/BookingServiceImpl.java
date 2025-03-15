package me.zhangyifeng.biz.modular.booking.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.xiaonuo.common.enums.CommonSortOrderEnum;
import vip.xiaonuo.common.exception.CommonException;
import vip.xiaonuo.common.page.CommonPageRequest;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import me.zhangyifeng.biz.modular.booking.enums.BookingStatusEnum;
import me.zhangyifeng.biz.modular.booking.mapper.BookingMapper;
import me.zhangyifeng.biz.modular.booking.param.BookingAddParam;
import me.zhangyifeng.biz.modular.booking.param.BookingEditParam;
import me.zhangyifeng.biz.modular.booking.param.BookingIdParam;
import me.zhangyifeng.biz.modular.booking.param.BookingPageParam;
import me.zhangyifeng.biz.modular.booking.service.BookingService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bookingService接口实现类
 *
 * @author 张一风
 * @date  2025/03/07 22:30
 **/
@Service
public class BookingServiceImpl extends ServiceImpl<BookingMapper, Booking> implements BookingService {

    @Override
    public Page<Booking> page(BookingPageParam bookingPageParam) {
        QueryWrapper<Booking> queryWrapper = new QueryWrapper<Booking>().checkSqlInjection();
        if(ObjectUtil.isNotEmpty(bookingPageParam.getStartStartTime()) && ObjectUtil.isNotEmpty(bookingPageParam.getEndStartTime())) {
            queryWrapper.lambda().between(Booking::getStartTime, bookingPageParam.getStartStartTime(), bookingPageParam.getEndStartTime());
        }
        if(ObjectUtil.isNotEmpty(bookingPageParam.getStartEndTime()) && ObjectUtil.isNotEmpty(bookingPageParam.getEndEndTime())) {
            queryWrapper.lambda().between(Booking::getEndTime, bookingPageParam.getStartEndTime(), bookingPageParam.getEndEndTime());
        }
        if(ObjectUtil.isNotEmpty(bookingPageParam.getStatus())) {
            queryWrapper.lambda().eq(Booking::getStatus, bookingPageParam.getStatus());
        }
        if(ObjectUtil.isNotEmpty(bookingPageParam.getBookingReference())) {
            queryWrapper.lambda().eq(Booking::getBookingReference, bookingPageParam.getBookingReference());
        }
        if(ObjectUtil.isNotEmpty(bookingPageParam.getStartCreateTime()) && ObjectUtil.isNotEmpty(bookingPageParam.getEndCreateTime())) {
            queryWrapper.lambda().between(Booking::getCreateTime, bookingPageParam.getStartCreateTime(), bookingPageParam.getEndCreateTime());
        }
        if(ObjectUtil.isNotEmpty(bookingPageParam.getStartUpdateTime()) && ObjectUtil.isNotEmpty(bookingPageParam.getEndUpdateTime())) {
            queryWrapper.lambda().between(Booking::getUpdateTime, bookingPageParam.getStartUpdateTime(), bookingPageParam.getEndUpdateTime());
        }
        if(ObjectUtil.isAllNotEmpty(bookingPageParam.getSortField(), bookingPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(bookingPageParam.getSortOrder());
            queryWrapper.orderBy(true, bookingPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()),
                    StrUtil.toUnderlineCase(bookingPageParam.getSortField()));
        } else {
            queryWrapper.lambda().orderByAsc(Booking::getId);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(BookingAddParam bookingAddParam) {
        Booking booking = BeanUtil.toBean(bookingAddParam, Booking.class);
        this.save(booking);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(BookingEditParam bookingEditParam) {
        Booking booking = this.queryEntity(bookingEditParam.getId());
        BeanUtil.copyProperties(bookingEditParam, booking);
        this.updateById(booking);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<BookingIdParam> bookingIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(bookingIdParamList, BookingIdParam::getId));
    }

    @Override
    public Booking detail(BookingIdParam bookingIdParam) {
        return this.queryEntity(bookingIdParam.getId());
    }

    @Override
    public Booking queryEntity(String id) {
        Booking booking = this.getById(id);
        if(ObjectUtil.isEmpty(booking)) {
            throw new CommonException("booking不存在，id值为：{}", id);
        }
        return booking;
    }

    @Override
    public BigDecimal getAmount(String loginIdAsString) {
        return this.baseMapper.sumTotalPriceByUserId(loginIdAsString);
    }

    /**
     * 获取周收入按租赁选项统计
     */
    @Override
    public Map<String, Double> getWeeklyIncomeByOption(LocalDate startDate, LocalDate endDate) {
        // 将 LocalDate 转换为 LocalDateTime 以便匹配数据库中的日期时间格式
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.plusDays(1).atStartOfDay();
        
        // 查询指定时间范围内且状态为已完成的预订
        QueryWrapper<Booking> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("option_id, SUM(total_price) as total")
                .ge("start_time", startDateTime)
                .lt("end_time", endDateTime)
                .eq("status", BookingStatusEnum.COMPLETED.getValue())
                .groupBy("option_id");
        
        List<Map<String, Object>> results = baseMapper.selectMaps(queryWrapper);
        
        // 初始化返回结果，确保即使没有数据，也返回所有选项
        Map<String, Double> incomeByOption = new HashMap<>();
        // OPT1:1小时, OPT2:4小时, OPT3:1天, OPT4:1周
        incomeByOption.put("OPT1", 0.0);
        incomeByOption.put("OPT2", 0.0);
        incomeByOption.put("OPT3", 0.0);
        incomeByOption.put("OPT4", 0.0);
        
        // 填充查询结果
        for (Map<String, Object> result : results) {
            String optionId = (String) result.get("option_id");
            Double total = ((Number) result.get("total")).doubleValue();
            incomeByOption.put(optionId, total);
        }
        
        return incomeByOption;
    }

    /**
     * 获取一周内每日总收入统计
     */
    @Override
    public List<Map<String, Object>> getDailyIncomeCombined(LocalDate startDate, LocalDate endDate) {
        // 将 LocalDate 转换为 LocalDateTime 以便匹配数据库中的日期时间格式
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.plusDays(1).atStartOfDay();
        
        // 创建一个只包含日期部分的提取SQL
        String dateFormat = "DATE_FORMAT(start_time, '%Y-%m-%d')";
        
        // 查询指定时间范围内且状态为已完成的预订，按日期分组
        QueryWrapper<Booking> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(dateFormat + " as date, SUM(total_price) as income")
                .ge("start_time", startDateTime)
                .lt("end_time", endDateTime)
                .eq("status", BookingStatusEnum.COMPLETED.getValue())
                .groupBy(dateFormat)
                .orderByAsc(dateFormat);
        
        List<Map<String, Object>> results = baseMapper.selectMaps(queryWrapper);
        
        // 确保所有日期都有记录，即使没有收入
        List<Map<String, Object>> dailyIncomes = ensureAllDates(startDate, endDate, results);
        
        return dailyIncomes;
    }
    
    /**
     * 确保所有日期都有记录，没有的设为0
     */
    private List<Map<String, Object>> ensureAllDates(LocalDate startDate, LocalDate endDate, List<Map<String, Object>> existingData) {
        Map<String, Double> dateIncomeMap = new HashMap<>();
        
        // 将现有数据放入map
        for (Map<String, Object> data : existingData) {
            String date = (String) data.get("date");
            Double income = ((Number) data.get("income")).doubleValue();
            dateIncomeMap.put(date, income);
        }
        
        List<Map<String, Object>> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // 遍历日期范围
        LocalDate current = startDate;
        while (!current.isAfter(endDate)) {
            String dateStr = current.format(formatter);
            Map<String, Object> dayData = new HashMap<>();
            dayData.put("date", dateStr);
            dayData.put("income", dateIncomeMap.getOrDefault(dateStr, 0.0));
            result.add(dayData);
            current = current.plusDays(1);
        }
        
        return result;
    }
}
