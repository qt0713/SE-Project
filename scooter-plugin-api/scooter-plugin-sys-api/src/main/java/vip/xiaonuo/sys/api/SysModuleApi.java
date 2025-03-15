
package vip.xiaonuo.sys.api;

import cn.hutool.json.JSONObject;
import java.util.List;

/**
 * 模块API
 *
 * @author yubaoshan
 * @date 2024/9/6 01:24
 **/
public interface SysModuleApi {

    /**
     * 获取所有模块
     *
     * @author yubaoshan
     * @date 2024/9/6 01:24
     **/
    List<JSONObject> moduleSelector();
}
