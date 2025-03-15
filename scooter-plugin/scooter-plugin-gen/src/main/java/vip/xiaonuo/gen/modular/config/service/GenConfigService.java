
package vip.xiaonuo.gen.modular.config.service;

import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.gen.modular.config.entity.GenConfig;
import vip.xiaonuo.gen.modular.config.param.GenConfigEditParam;
import vip.xiaonuo.gen.modular.config.param.GenConfigIdParam;
import vip.xiaonuo.gen.modular.config.param.GenConfigListParam;

import java.util.List;

/**
 * 代码生成详细配置配置Service接口
 *
 * @author yubaoshan
 * @date 2022/10/25 22:33
 **/
public interface GenConfigService extends IService<GenConfig> {

    /**
     * 查询代码生成详细配置列表
     *
     * @author yubaoshan
     * @date 2022/10/25 22:33
     */
    List<GenConfig> list(GenConfigListParam genConfigListParam);

    /**
     * 编辑代码生成详细配置
     *
     * @author yubaoshan
     * @date 2022/10/25 22:33
     */
    void edit(GenConfigEditParam genConfigEditParam);

    /**
     * 删除代码生成详细配置
     *
     * @author yubaoshan
     * @date 2022/10/25 22:33
     */
    void delete(List<GenConfigIdParam> genConfigIdParamList);

    /**
     * 获取代码生成详细配置详情
     *
     * @author yubaoshan
     * @date 2022/10/25 22:33
     */
    GenConfig detail(GenConfigIdParam genConfigIdParam);

    /**
     * 获取代码生成详细配置详情
     *
     * @author yubaoshan
     * @date 2022/10/25 22:33
     **/
    GenConfig queryEntity(String id);

    /**
     * 批量编辑代码生成详细配置
     *
     * @author xuyuxiang
     * @date 2022/10/28 13:49
     **/
    void editBatch(List<GenConfigEditParam> genConfigEditParamList);
}
