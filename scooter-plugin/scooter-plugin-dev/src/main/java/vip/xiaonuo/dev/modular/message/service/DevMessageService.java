
package vip.xiaonuo.dev.modular.message.service;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.dev.modular.message.entity.DevMessage;
import vip.xiaonuo.dev.modular.message.param.DevMessageIdParam;
import vip.xiaonuo.dev.modular.message.param.DevMessageListParam;
import vip.xiaonuo.dev.modular.message.param.DevMessagePageParam;
import vip.xiaonuo.dev.modular.message.param.DevMessageSendParam;
import vip.xiaonuo.dev.modular.message.result.DevMessageResult;

import java.util.List;

/**
 * 站内信Service接口
 *
 * @author xuyuxiang
 * @date 2022/6/21 14:54
 **/
public interface DevMessageService extends IService<DevMessage> {

    /**
     * 发送站内信
     *
     * @author xuyuxiang
     * @date 2022/6/21 18:37
     **/
    void send(DevMessageSendParam devMessageSendParam);

    /**
     * 获取站内信分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    Page<DevMessage> page(DevMessagePageParam devMessagePageParam);

    /**
     * 获取站内信分页，返回JSONObject分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    Page<JSONObject> page(List<String> receiverIdList, String category);

    /**
     * 获取站内信列表
     *
     * @author xuyuxiang
     * @date 2022/9/2 11:50
     */
    List<DevMessage> list(DevMessageListParam devMessageListParam);

    /**
     * 获取未读站内信数量
     *
     * @author diantu
     * @date 2023/7/10
     */
    Long unreadCount(String loginId);

    /**
     * 删除站内信
     *
     * @author xuyuxiang
     * @date 2022/8/4 10:36
     **/
    void delete(List<DevMessageIdParam> devMessageIdParamList);

    /**
     * 获取站内信详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    DevMessageResult detail(DevMessageIdParam devMessageIdParam);

    /**
     * 获取站内信详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    DevMessage queryEntity(String id);
}
