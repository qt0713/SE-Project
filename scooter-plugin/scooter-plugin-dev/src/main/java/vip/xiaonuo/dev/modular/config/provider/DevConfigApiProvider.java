
package vip.xiaonuo.dev.modular.config.provider;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import vip.xiaonuo.dev.api.DevConfigApi;
import vip.xiaonuo.dev.modular.config.service.DevConfigService;

/**
 * 配置API接口实现类
 *
 * @author xuyuxiang
 * @date 2022/6/17 14:43
 **/
@Service
public class DevConfigApiProvider implements DevConfigApi {

    @Resource
    private DevConfigService devConfigService;

    @Override
    public String getValueByKey(String key) {
        return devConfigService.getValueByKey(key);
    }
}
