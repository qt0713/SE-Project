
package vip.xiaonuo.biz.api;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 机构API
 *
 * @author yubaoshan
 * @date 2024/11/1 18:27:51
 **/
public interface BizOrgApi {

    /**
     * 获取组织树选择器
     *
     * @author yubaoshan
     * @date 2024/11/1 18:27:51
     **/
    List<Tree<String>> orgTreeSelector();

    /**
     * 获取组织列表选择器
     *
     * @author yubaoshan
     * @date 2024/11/1 18:27:51
     **/
    Page<JSONObject> orgListSelector(String parentId);
}
