
package vip.xiaonuo.dev.modular.sms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.dev.modular.sms.entity.DevSms;
import vip.xiaonuo.dev.modular.sms.param.*;

import java.util.List;

/**
 * 短信Service接口
 *
 * @author xuyuxiang
 * @date 2022/2/23 18:27
 **/
public interface DevSmsService extends IService<DevSms> {

    /**
     * 发送短信——阿里云
     *
     * @author xuyuxiang
     * @date 2022/6/21 18:37
     **/
    void sendAliyun(DevSmsSendAliyunParam devSmsSendAliyunParam);

    /**
     * 发送短信——腾讯云
     *
     * @author xuyuxiang
     * @date 2022/6/21 18:37
     **/
    void sendTencent(DevSmsSendTencentParam devSmsSendTencentParam);

    /**
     * 发送短信——小诺短信
     *
     * @author xuyuxiang
     * @date 2024/1/25 14:08
     **/
    void sendXiaonuo(DevSmsSendXiaonuoParam devSmsSendXiaonuoParam);

    /**
     * 获取短信分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    Page<DevSms> page(DevSmsPageParam devSmsPageParam);

    /**
     * 删除短信
     *
     * @author xuyuxiang
     * @date 2022/8/4 10:36
     **/
    void delete(List<DevSmsIdParam> devSmsIdParamList);

    /**
     * 获取短信详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    DevSms detail(DevSmsIdParam devSmsIdParam);

    /**
     * 获取短信详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    DevSms queryEntity(String id);
}
