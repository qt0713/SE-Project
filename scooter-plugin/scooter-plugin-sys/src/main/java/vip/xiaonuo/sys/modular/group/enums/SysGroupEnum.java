
package vip.xiaonuo.sys.modular.group.enums;

import lombok.Getter;

/**
 * 用户组枚举
 *
 * @author yubaoshan
 * @date  2024/12/21 01:25
 **/
@Getter
public enum SysGroupEnum {

    /** 测试 */
    TEST("TEST");

    private final String value;

    SysGroupEnum(String value) {
        this.value = value;
    }
}
