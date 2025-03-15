
package vip.xiaonuo.dev.modular.config.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.dev.modular.config.entity.DevConfig;
import vip.xiaonuo.dev.modular.config.param.*;

import java.util.List;

/**
 * 配置Service接口
 *
 * @author xuyuxiang
 * @date 2022/4/22 10:41
 **/
public interface DevConfigService extends IService<DevConfig> {

    /**
     * 根据键获取值
     *
     * @author xuyuxiang
     * @date 2022/4/22 14:52
     **/
    String getValueByKey(String key);

    /**
     * 获取配置分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    Page<DevConfig> page(DevConfigPageParam devConfigPageParam);

    /**
     * 获取基础配置列表
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    List<DevConfig> sysBaseList();

    /**
     * 获取配置列表
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    List<DevConfig> list(DevConfigListParam devConfigListParam);

    /**
     * 添加配置
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:48
     */
    void add(DevConfigAddParam devConfigAddParam);

    /**
     * 编辑配置
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:13
     */
    void edit(DevConfigEditParam devConfigEditParam);

    /**
     * 删除配置
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    void delete(List<DevConfigIdParam> devConfigIdParamList);

    /**
     * 获取配置详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    DevConfig detail(DevConfigIdParam devConfigIdParam);

    /**
     * 获取配置详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    DevConfig queryEntity(String id);

    /**
     * 配置批量更新
     *
     * @author xuyuxiang
     * @date 2022/6/28 11:09
     **/
    void editBatch(List<DevConfigBatchParam> devConfigBatchParamList);
}
