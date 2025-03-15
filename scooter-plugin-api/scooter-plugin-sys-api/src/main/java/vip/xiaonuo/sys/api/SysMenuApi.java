
package vip.xiaonuo.sys.api;

import cn.hutool.core.lang.tree.Tree;

import java.util.List;

/**
 * 菜单API
 *
 * @author xuyuxiang
 * @date 2022/11/1 13:44
 **/
public interface SysMenuApi {

    /**
     * 代码生成菜单插入
     *
     * @author xuyuxiang
     * @date 2022/11/1 13:48
     **/
    String addForGenMenu(String parentId, String busName, String module, String title, String path);

    /**
     * 获取所有菜单树包括未授权的
     *
     * @author yubaoshan
     * @date 2024/9/6 01:24
     **/
    List<Tree<String>> menuTreeSelector(String module);
}
