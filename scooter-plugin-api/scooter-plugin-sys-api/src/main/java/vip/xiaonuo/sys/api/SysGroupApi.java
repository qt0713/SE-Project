
package vip.xiaonuo.sys.api;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 用户组Api
 *
 * @author xuyuxiang
 * @date 2022/6/6 11:33
 **/
public interface SysGroupApi {

    /**
     * 获取用户组拥有人员
     *
     * @author xuyuxiang
     * @date 2022/5/13 21:00
     */
    List<String> ownUser(String groupId);

    /**
     * 给用户组授权用户
     *
     * @author xuyuxiang
     * @date 2022/8/1 18:28
     */
    void grantUser(String groupId, List<String> userIdList);

    /**
     * 获取用户组选择器
     *
     * @author yubaoshan
     * @date 2025/1/12 02:36
     */
    Page<JSONObject> groupSelector(String searchKey, int current, int size);
}
