
package vip.xiaonuo.dev.modular.sse.enums;

import lombok.Getter;

/**
 * SSE通信参数枚举
 *
 * @author diantu
 * @date 2023/7/17
 **/
@Getter
public enum DevSseEmitterParameterEnum {

    /**
     * 通信
     */
    EMITTER("EMITTER"),

    /**
     * 心跳
     */
    FUTURE("FUTURE"),

    /**
     * 用户ID
     */
    LOGINID("LOGINID");

    private final String value;

    DevSseEmitterParameterEnum(String value) {
        this.value = value;
    }

}
