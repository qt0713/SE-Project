
package vip.xiaonuo.dev.modular.log.enums;

import lombok.Getter;

/**
 * 日志执行状态枚举
 *
 * @author xuyuxiang
 * @date 2022/6/16 16:14
 **/
@Getter
public enum DevLogExeStatusEnum {

    /** 成功 */
    SUCCESS("SUCCESS"),

    /** 失败 */
    FAIL("FAIL");

    private final String value;

    DevLogExeStatusEnum(String value) {
        this.value = value;
    }
}
