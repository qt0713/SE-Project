
package me.zhangyifeng.biz.modular.payment.enums;

import lombok.Getter;

/**
 * Payment枚举
 *
 * @author 张一风
 * @date  2025/03/07 23:02
 **/
@Getter
public enum PaymentEnum {

    /** 测试 */
    TEST("TEST");

    private final String value;

    PaymentEnum(String value) {
        this.value = value;
    }
}
