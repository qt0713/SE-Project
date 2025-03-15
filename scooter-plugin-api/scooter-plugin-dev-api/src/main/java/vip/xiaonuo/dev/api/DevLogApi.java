
package vip.xiaonuo.dev.api;

import cn.hutool.json.JSONObject;

import java.util.List;

/**
 * 日志API
 *
 * @author xuyuxiang
 * @date 2022/9/2 15:59
 */
public interface DevLogApi {

    /**
     * 记录登录日志
     *
     * @author xuyuxiang
     * @date 2022/9/2 16:03
     */
    void executeLoginLog(String userName);

    /**
     * 记录登出日志
     *
     * @author xuyuxiang
     * @date 2022/9/2 16:03
     */
    void executeLogoutLog(String userName);

    /**
     * 获取当前用户的访问日志列表
     *
     * @author xuyuxiang
     * @date 2022/9/4 15:12
     */
    List<JSONObject> currentUserVisLogList();

    /**
     * 获取当前用户的操作日志列表
     *
     * @author xuyuxiang
     * @date 2022/9/4 15:12
     */
    List<JSONObject> currentUserOpLogList();
}
