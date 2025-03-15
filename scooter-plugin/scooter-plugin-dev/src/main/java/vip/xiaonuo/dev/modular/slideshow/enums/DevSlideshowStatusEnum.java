
package vip.xiaonuo.dev.modular.slideshow.enums;

import lombok.Getter;
import vip.xiaonuo.common.exception.CommonException;

/**
 * 轮播图状态枚举
 *
 * @author yubaoshan
 * @date  2024/07/11 14:46
 */
@Getter
public enum DevSlideshowStatusEnum {

    /**
     * 正常
     */
    ENABLE("ENABLE"),

    /**
     * 禁用
     */
    DISABLE("DISABLE");

    private final String value;

    DevSlideshowStatusEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = ENABLE.getValue().equals(value) || DISABLE.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的状态：{}", value);
        }
    }
}
