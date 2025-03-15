
package me.zhangyifeng.biz.modular.userDiscount.enums;

import lombok.Getter;

/**
 * UserDiscount枚举
 *
 * @author 张一风
 * @date  2025/03/07 23:09
 **/
@Getter
public enum UserDiscountEnum {

    /** 测试 */
    TEST("TEST");

    private final String value;

    UserDiscountEnum(String value) {
        this.value = value;
    }
}
