
package vip.xiaonuo.sys.modular.role.enums;

import lombok.Getter;
import vip.xiaonuo.common.exception.CommonException;

/**
 * 角色分类枚举
 *
 * @author xuyuxiang
 * @date 2022/4/21 19:56
 **/
@Getter
public enum SysRoleCategoryEnum {

    /** 全局 */
    GLOBAL("GLOBAL"),

    /** 组织 */
    ORG("ORG");

    private final String value;

    SysRoleCategoryEnum(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = GLOBAL.getValue().equals(value) || ORG.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的角色分类：{}", value);
        }
    }
}
