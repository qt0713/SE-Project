
package me.zhangyifeng.biz.modular.booking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.zhangyifeng.biz.modular.booking.entity.Booking;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

/**
 * bookingMapper接口
 *
 * @author 张一风
 * @date  2025/03/07 22:30
 **/
public interface BookingMapper extends BaseMapper<Booking> {

    @Select("select sum(total_price) from booking where user_id = #{user_id} and status = 'COMPLETED' ")
    BigDecimal sumTotalPriceByUserId(String userId);
}
