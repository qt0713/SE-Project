
package vip.xiaonuo.sys.api;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 职位API
 *
 * @author xuyuxiang
 * @date 2022/6/6 11:35
 **/
public interface SysPositionApi {

    /**
     * 根据id获取名称
     *
     * @author xuyuxiang
     * @date 2022/8/4 10:13
     **/
    String getNameById(String positionId);

    /**
     * 获取职位选择器
     *
     * @author xuyuxiang
     * @date 2022/7/22 14:47
     **/
    Page<JSONObject> positionSelector(String orgId, String searchKey);
}
