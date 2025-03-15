
package vip.xiaonuo.sys.modular.group.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.sys.modular.group.entity.SysGroup;
import vip.xiaonuo.sys.modular.group.param.*;
import vip.xiaonuo.sys.modular.user.entity.SysUser;

import java.util.List;

/**
 * 用户组Service接口
 *
 * @author yubaoshan
 * @date  2024/12/21 01:25
 **/
public interface SysGroupService extends IService<SysGroup> {

    /**
     * 获取用户组分页
     *
     * @author yubaoshan
     * @date  2024/12/21 01:25
     */
    Page<SysGroup> page(SysGroupPageParam sysGroupPageParam);

    /**
     * 添加用户组
     *
     * @author yubaoshan
     * @date  2024/12/21 01:25
     */
    void add(SysGroupAddParam sysGroupAddParam);

    /**
     * 编辑用户组
     *
     * @author yubaoshan
     * @date  2024/12/21 01:25
     */
    void edit(SysGroupEditParam sysGroupEditParam);

    /**
     * 删除用户组
     *
     * @author yubaoshan
     * @date  2024/12/21 01:25
     */
    void delete(List<SysGroupIdParam> sysGroupIdParamList);

    /**
     * 获取用户组详情
     *
     * @author yubaoshan
     * @date  2024/12/21 01:25
     */
    SysGroup detail(SysGroupIdParam sysGroupIdParam);

    /**
     * 获取用户组详情
     *
     * @author yubaoshan
     * @date  2024/12/21 01:25
     **/
    SysGroup queryEntity(String id);

    /**
     * 获取用户组下的用户
     *
     * @author yubaoshan
     * @date 2024/12/21 01:25
     */
    List<String> ownUser(SysGroupIdParam sysGroupIdParam);

    /**
     * 获取组织树选择器
     *
     * @author yubaoshan
     * @date 2024/12/21 01:25
     */
    List<Tree<String>> orgTreeSelector();

    /**
     * 获取用户选择器
     *
     * @author yubaoshan
     * @date 2024/12/21 01:25
     */
    Page<SysUser> userSelector(SysGroupSelectorUserParam sysGroupSelectorUserParam);

    /**
     * 给用户组授权用户
     *
     * @author yubaoshan
     * @date 2024/12/21 01:25
     */
    void grantUser(SysGroupGrantUserParam sysGroupGrantUserParam);

    /**
     * 获取用户组选择器
     *
     * @author yubaoshan
     * @date 2024/12/21 01:25
     */
    Page<SysGroup> groupSelector(SysGroupSelectorParam sysGroupSelectorParam);
}
