
package vip.xiaonuo.dev.modular.slideshow.enums;

import lombok.Getter;

/**
 * 轮播图枚举
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 **/
@Getter
public enum DevSlideshowEnum {

    /** 测试 */
    TEST("TEST");

    private final String value;

    DevSlideshowEnum(String value) {
        this.value = value;
    }
}
