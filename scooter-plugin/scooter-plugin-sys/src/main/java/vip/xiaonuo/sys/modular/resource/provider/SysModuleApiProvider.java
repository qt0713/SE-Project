
package vip.xiaonuo.sys.modular.resource.provider;

import cn.hutool.json.JSONObject;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import vip.xiaonuo.sys.api.SysModuleApi;
import vip.xiaonuo.sys.modular.resource.service.SysModuleService;

import java.util.List;

/**
 * 模块API接口实现类
 *
 * @author yubaoshan
 * @date 2024/9/6 01:24
 **/
@Service
public class SysModuleApiProvider implements SysModuleApi {

    @Resource
    private SysModuleService sysModuleService;

    @Override
    public List<JSONObject> moduleSelector() {
        return sysModuleService.moduleSelector();
    }
}
