
package vip.xiaonuo.auth.api;

import cn.hutool.json.JSONObject;

/**
 * 认证鉴权API
 *
 * @author yubaoshan
 * @date 2024/7/18 17:35
 */
public interface AuthApi {

    /**
     * 获取基础登录业务数据，b端在线用户，c端在线用户
     *
     * @author yubaoshan
     * @date 2024/7/18 17:35
     */
    JSONObject getUserSessionCount();

    /**
     * 获取三方用户总量
     *
     * @author yubaoshan
     * @date 2024/7/18 17:35
     */
    Long getThirdUserCount();
}
