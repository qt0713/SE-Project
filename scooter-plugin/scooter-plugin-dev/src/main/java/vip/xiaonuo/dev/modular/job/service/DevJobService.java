
package vip.xiaonuo.dev.modular.job.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.dev.modular.job.entity.DevJob;
import vip.xiaonuo.dev.modular.job.param.*;

import java.util.List;

/**
 * 定时任务Service接口
 *
 * @author xuyuxiang
 * @date 2022/8/5 10:46
 **/
public interface DevJobService extends IService<DevJob> {

    /**
     * 获取定时任务分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    Page<DevJob> page(DevJobPageParam devJobPageParam);

    /**
     * 获取定时任务列表
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    List<DevJob> list(DevJobListParam devJobListParam);

    /**
     * 添加定时任务
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:48
     */
    void add(DevJobAddParam devJobAddParam);

    /**
     * 编辑定时任务
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:13
     */
    void edit(DevJobEditParam devJobEditParam);

    /**
     * 删除定时任务
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    void delete(List<DevJobIdParam> devJobIdParamList);

    /**
     * 获取定时任务详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    DevJob detail(DevJobIdParam devJobIdParam);

    /**
     * 获取定时任务详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    DevJob queryEntity(String id);

    /**
     * 停止定时任务
     *
     * @author xuyuxiang
     * @date 2022/7/5 18:20
     **/
    void stopJob(DevJobIdParam devJobIdParam);

    /**
     * 运行定时任务
     *
     * @author xuyuxiang
     * @date 2022/7/5 18:21
     **/
    void runJob(DevJobIdParam devJobIdParam);

    /**
     * 立即运行定时任务
     *
     * @author xuyuxiang
     * @date 2023/3/3 15:50
     **/
    void runJobNow(DevJobIdParam devJobIdParam);

    /**
     * 获取定时任务类
     *
     * @author xuyuxiang
     * @date 2022/8/22 9:35
     **/
    List<String> getActionClass();
}
