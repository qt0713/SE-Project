
package me.zhangyifeng.biz.modular.rentalOption.enums;

import lombok.Getter;

/**
 * RentalOption枚举
 *
 * @author 张一风
 * @date  2025/03/07 22:56
 **/
@Getter
public enum RentalOptionEnum {

    /** 测试 */
    TEST("TEST");

    private final String value;

    RentalOptionEnum(String value) {
        this.value = value;
    }
}
