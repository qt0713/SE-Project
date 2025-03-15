
package me.zhangyifeng.feedback.modular.feedback.enums;

import lombok.Getter;

/**
 * Feedback枚举
 *
 * @author 张一风
 * @date  2025/03/10 12:38
 **/
@Getter
public enum FeedbackEnum {

    /** 测试 */
    TEST("TEST");

    private final String value;

    FeedbackEnum(String value) {
        this.value = value;
    }
}
