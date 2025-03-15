
package vip.xiaonuo.dev.modular.email.enums;

import lombok.Getter;

/**
 * 邮件类型枚举
 *
 * @author xuyuxiang
 * @date 2022/6/16 16:14
 **/
@Getter
public enum DevEmailTypeEnum {

    /** 纯文本 */
    TEXT("TEXT"),

    /** 富文本 */
    HTML("HTML"),

    /** 模板 */
    TEMPLATE("TEMPLATE");

    private final String value;

    DevEmailTypeEnum(String value) {
        this.value = value;
    }
}
