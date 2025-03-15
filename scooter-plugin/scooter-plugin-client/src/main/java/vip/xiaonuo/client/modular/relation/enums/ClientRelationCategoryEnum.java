
package vip.xiaonuo.client.modular.relation.enums;

import lombok.Getter;

/**
 * C端关系分类枚举
 *
 * @author xuyuxiang
 * @date 2022/4/21 19:56
 **/
@Getter
public enum ClientRelationCategoryEnum {

    /* ====C端用户与其他关系==== */

    /** 测试关系 */
    USER_TEST("USER_TEST");

    private final String value;

    ClientRelationCategoryEnum(String value) {
        this.value = value;
    }
}
