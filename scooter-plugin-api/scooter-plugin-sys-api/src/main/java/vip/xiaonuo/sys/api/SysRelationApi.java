
package vip.xiaonuo.sys.api;

import java.util.List;

/**
 * 关系API
 *
 * @author xuyuxiang
 * @date 2022/6/6 11:41
 **/
public interface SysRelationApi {

    /**
     * 根据角色id集合获取角色下用户id集合
     *
     * @author xuyuxiang
     * @date 2022/6/6 11:43
     **/
    List<String> getUserIdListByRoleIdList(List<String> roleIdList);

    /**
     * 根据用户组id集合获取用户组下用户id集合
     *
     * @author xuyuxiang
     * @date 2022/6/6 11:43
     **/
    List<String> getUserIdListByGroupIdList(List<String> groupIdList);

    /**
     * 根据移动端菜单Id集合移除角色和移动端菜单关系
     *
     * @author xuyuxiang
     * @date 2023/1/31 9:54
     **/
    void removeRoleHasMobileMenuRelation(List<String> targetIdList);

    /**
     * 清除对应的角色与移动端菜单信息中的【授权的移动端按钮信息】
     *
     * @author xuyuxiang
     * @date 2023/1/31 9:54
     **/
    void removeRoleHasMobileButtonRelation(List<String> targetIdList, List<String> buttonIdList);
}
