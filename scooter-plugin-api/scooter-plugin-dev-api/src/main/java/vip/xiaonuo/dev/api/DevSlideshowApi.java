
package vip.xiaonuo.dev.api;

import cn.hutool.json.JSONObject;

import java.util.List;

/**
 * 轮播图API
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 */
public interface DevSlideshowApi {

    /**
     * 通过位置获得轮播图列表
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     **/
    List<JSONObject> getListByPlace(String place);
}
