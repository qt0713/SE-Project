
package vip.xiaonuo.biz.api;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 用户Api
 *
 * @author yubaoshan
 * @date 2024/11/1 18:27:51
 **/
public interface BizUserApi {

    /**
     * 获取用户选择器
     *
     * @author yubaoshan
     * @date 2024/11/1 18:27:51
     */
    Page<JSONObject> userSelector(String orgId, String searchKey);
}
