package me.zhangyifeng.modular.user.enums;

import lombok.Getter;

@Getter
public enum ClientUserExceptionEnum {
    /**
     * 用户注册失败
     */
    USER_REGISTER_ERROR("User registration failed"),
    /**
     * 验证码不能为空
     */
    VALID_CODE_EMPTY("验证码不能为空"),

    /**
     * 验证码请求号不能为空
     */
    VALID_CODE_REQ_NO_EMPTY("验证码请求号不能为空"),

    EMAIL_EXISTED("邮箱已存在"),
    ;
    private final String value;

    ClientUserExceptionEnum(String value) {
        this.value = value;
    }
}
