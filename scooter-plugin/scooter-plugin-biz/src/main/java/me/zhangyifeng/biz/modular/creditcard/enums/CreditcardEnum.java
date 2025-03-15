
package me.zhangyifeng.biz.modular.creditcard.enums;

import lombok.Getter;

/**
 * CreditCard枚举
 *
 * @author 张一风
 * @date  2025/03/09 11:38
 **/
@Getter
public enum CreditcardEnum {

    /** 测试 */
    TEST("TEST");

    private final String value;

    CreditcardEnum(String value) {
        this.value = value;
    }
}
