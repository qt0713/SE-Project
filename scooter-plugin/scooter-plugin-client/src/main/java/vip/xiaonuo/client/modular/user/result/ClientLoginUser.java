
package vip.xiaonuo.client.modular.user.result;

import vip.xiaonuo.auth.core.pojo.SaBaseClientLoginUser;
import vip.xiaonuo.client.modular.user.enums.ClientUserStatusEnum;

/**
 * C端登录用户对象
 *
 * @author xuyuxiang
 * @date 2022/4/21 19:33
 **/
public class ClientLoginUser extends SaBaseClientLoginUser {

    /**
     * 实现是否可以登录
     *
     * @author xuyuxiang
     * @date 2022/8/15 15:27
     **/
    @Override
    public Boolean getEnabled() {
        // 仅判断状态是否正常，可自行扩展
        return this.getUserStatus().equals(ClientUserStatusEnum.ENABLE.getValue());
    }
}
