
package me.zhangyifeng.biz.modular.booking.enums;

import lombok.Getter;

/**
 * booking枚举
 *
 * @author 张一风
 * @date  2025/03/07 22:30
 **/
@Getter
public enum BookingStatusEnum {
    CANCELLED("CANCELLED"),
    PENDING("PENDING"),
    /** 测试 */
    COMPLETED("COMPLETED");


    private final String value;

    BookingStatusEnum(String value) {
        this.value = value;
    }
}
