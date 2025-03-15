
package vip.xiaonuo.dev.api;

import cn.hutool.json.JSONObject;

/**
 * 开发工具模块综合API
 *
 * @author xuyuxiang
 * @date 2022/9/26 14:24
 **/
public interface DevApi {

    /**
     * 获得dev模块运维数据
     *
     * @author yubaoshan
     * @date 2024/7/18 17:35
     **/
    JSONObject getDevOpCount();

    /**
     * 获得dev工具数量（短信、邮件、文件、消息）
     *
     * @author yubaoshan
     * @date 2024/7/18 17:35
     **/
    JSONObject getToolDataCount();
}
