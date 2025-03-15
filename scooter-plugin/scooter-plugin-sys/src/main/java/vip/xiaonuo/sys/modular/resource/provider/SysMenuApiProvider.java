
package vip.xiaonuo.sys.modular.resource.provider;

import cn.hutool.core.lang.tree.Tree;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import vip.xiaonuo.sys.api.SysMenuApi;
import vip.xiaonuo.sys.modular.resource.param.menu.SysMenuSelectorMenuParam;
import vip.xiaonuo.sys.modular.resource.service.SysMenuService;

import java.util.List;

/**
 * 菜单API接口实现类
 *
 * @author xuyuxiang
 * @date 2022/11/1 13:50
 **/
@Service
public class SysMenuApiProvider implements SysMenuApi {

    @Resource
    private SysMenuService sysMenuService;

    @Override
    public String addForGenMenu(String parentId, String busName, String module, String title, String path) {
        return sysMenuService.addForGenMenu(parentId, busName, title, module, path);
    }

    @Override
    public List<Tree<String>> menuTreeSelector(String module) {
        SysMenuSelectorMenuParam param = new SysMenuSelectorMenuParam();
        param.setModule(module);
        return sysMenuService.menuTreeSelector(param);
    }
}
