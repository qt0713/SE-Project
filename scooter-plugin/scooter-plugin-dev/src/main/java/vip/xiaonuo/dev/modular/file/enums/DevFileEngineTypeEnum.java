
package vip.xiaonuo.dev.modular.file.enums;

import lombok.Getter;

/**
 * 文件存储引擎类型枚举
 *
 * @author xuyuxiang
 * @date 2022/6/16 16:14
 **/
@Getter
public enum DevFileEngineTypeEnum {

    /** 本地 */
    LOCAL("LOCAL"),

    /** 阿里云 */
    ALIYUN("ALIYUN"),

    /** 腾讯云 */
    TENCENT("TENCENT"),

    /** MINIO */
    MINIO("MINIO");

    private final String value;

    DevFileEngineTypeEnum(String value) {
        this.value = value;
    }
}
