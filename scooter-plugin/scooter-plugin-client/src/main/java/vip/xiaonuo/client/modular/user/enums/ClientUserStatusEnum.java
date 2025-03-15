
package vip.xiaonuo.client.modular.user.enums;

import lombok.Getter;
import vip.xiaonuo.common.exception.CommonException;

/**
 * C端用户状态枚举
 *
 * @author xuyuxiang
 * @date 2022/4/27 21:47
 */
@Getter
public enum ClientUserStatusEnum {

    /**
     * 正常
     */
    ENABLE("ENABLE"),

    /**
     * 停用
     */
    DISABLED("DISABLED");

    private final String value;

    ClientUserStatusEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = ENABLE.getValue().equals(value) || DISABLED.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的C端用户状态：{}", value);
        }
    }
}
