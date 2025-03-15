
package vip.xiaonuo.gen.modular.basic.enums;

import lombok.Getter;

/**
 * 是与否枚举
 *
 * @author yubaoshan
 * @date 2022/10/25 22:33
 **/
@Getter
public enum GenYesNoEnum {

    /** 是 */
    Y("Y"),

    /** 否 */
    N("N");

    private final String value;

    GenYesNoEnum(String value) {
        this.value = value;
    }
}
