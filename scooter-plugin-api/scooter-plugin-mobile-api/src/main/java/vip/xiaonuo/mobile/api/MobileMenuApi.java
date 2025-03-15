
package vip.xiaonuo.mobile.api;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.json.JSONObject;

import java.util.List;

/**
 * 移动端菜单API
 *
 * @author xuyuxiang
 * @date 2023/1/31 10:09
 **/
public interface MobileMenuApi {

    /**
     * 获取移动端菜单授权树
     *
     * @author xuyuxiang
     * @date 2023/1/31 10:10
     **/
    List<JSONObject> mobileMenuTreeSelector();

    /**
     * 获取移动端登录菜单树
     *
     * @author xuyuxiang
     * @date 2023/1/31 10:29
     **/
    List<Tree<String>> loginMobileMenuTree(List<String> menuIdList);
}
