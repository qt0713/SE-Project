
package vip.xiaonuo.sys.modular.group.provider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import vip.xiaonuo.sys.api.SysGroupApi;
import vip.xiaonuo.sys.modular.group.param.SysGroupGrantUserParam;
import vip.xiaonuo.sys.modular.group.param.SysGroupIdParam;
import vip.xiaonuo.sys.modular.group.param.SysGroupSelectorParam;
import vip.xiaonuo.sys.modular.group.service.SysGroupService;
import java.util.List;

/**
 * 用户组API接口提供者
 *
 * @author yubaoshan
 * @date  2024/12/21 01:25
 **/
@Service
public class SysGroupApiProvider implements SysGroupApi {

    @Resource
    private SysGroupService sysGroupService;

    @Override
    public List<String> ownUser(String groupId) {
        SysGroupIdParam sysGroupIdParam = new SysGroupIdParam();
        sysGroupIdParam.setId(groupId);
        return sysGroupService.ownUser(sysGroupIdParam);
    }

    @Override
    public void grantUser(String groupId, List<String> userIdList) {
        SysGroupGrantUserParam sysGroupGrantUserParam = new SysGroupGrantUserParam();
        sysGroupGrantUserParam.setId(groupId);
        sysGroupGrantUserParam.setGrantInfoList(userIdList);
        sysGroupService.grantUser(sysGroupGrantUserParam);
    }

    @SuppressWarnings("ALL")
    @Override
    public Page<JSONObject> groupSelector(String searchKey, int current, int size) {
        SysGroupSelectorParam sysGroupSelectorParam = new SysGroupSelectorParam();
        sysGroupSelectorParam.setCurrent(current);
        sysGroupSelectorParam.setSize(size);
        sysGroupSelectorParam.setSearchKey(searchKey);
        return BeanUtil.toBean(sysGroupService.groupSelector(sysGroupSelectorParam), Page.class);
    }
}
