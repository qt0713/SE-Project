
package me.zhangyifeng.biz.modular.scooter.enums;

import lombok.Getter;

/**
 * Scooter枚举
 *
 * @author 张一风
 * @date  2025/03/07 22:51
 **/
@Getter
public enum ScooterEnum {

    /** 测试 */
    TEST("TEST");

    private final String value;

    ScooterEnum(String value) {
        this.value = value;
    }
}
