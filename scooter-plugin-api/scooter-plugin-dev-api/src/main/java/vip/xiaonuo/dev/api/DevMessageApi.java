
package vip.xiaonuo.dev.api;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 站内信API接口
 *
 * @author xuyuxiang
 * @date 2022/6/22 17:33
 **/
public interface DevMessageApi {

    /**
     * 发送站内信，默认：分类系统通知
     *
     * @param receiverIdList 接收的用户id集合
     * @param subject 主题
     * @author xuyuxiang
     * @date 2022/6/22 17:35
     **/
    void sendMessage(List<String> receiverIdList, String subject);

    /**
     * 发送站内信指定分类
     *
     * @param receiverIdList 接收的用户id集合
     * @param subject 主题
     * @author xuyuxiang
     * @date 2022/6/22 17:35
     **/
    void sendMessage(List<String> receiverIdList, String category, String subject);

    /**
     * 发送站内信带内容，默认：分类系统通知
     *
     * @param receiverIdList 接收的用户id集合
     * @param subject 主题
     * @param content 站内信内容
     * @author xuyuxiang
     * @date 2022/6/22 17:35
     **/
    void sendMessageWithContent(List<String> receiverIdList, String subject, String content);

    /**
     * 发送站内信带内容，指定分类
     *
     * @param receiverIdList 接收的用户id集合
     * @param subject 主题
     * @param content 站内信内容
     * @author xuyuxiang
     * @date 2022/6/22 17:35
     **/
    void sendMessageWithContent(List<String> receiverIdList, String category, String subject, String content);

    /**
     * 获取未读站内信列表
     *
     * @author xuyuxiang
     * @date 2022/9/2 11:48
     */
    List<JSONObject> list(List<String> receiverIdList, Integer limit);

    /**
     * 获取未读站内信数量
     *
     * @author diantu
     * @date 2023/7/10
     */
    Long unreadCount(String loginId);

    /**
     * 获取站内信分页
     *
     * @author xuyuxiang
     * @date 2022/9/2 11:48
     */
    Page<JSONObject> page(List<String> receiverIdList, String category);

    /**
     * 获取站内信详情
     *
     * @param id 站内信id
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    JSONObject detail(String id);

    /**
     * 站内信全部标记已读
     *
     * @author diantu
     * @date 2023/7/10
     */
    void allMessageMarkRead();

}
