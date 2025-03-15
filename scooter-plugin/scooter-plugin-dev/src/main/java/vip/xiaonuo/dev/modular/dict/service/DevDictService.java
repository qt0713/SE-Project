
package vip.xiaonuo.dev.modular.dict.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.dev.modular.dict.entity.DevDict;
import vip.xiaonuo.dev.modular.dict.param.*;

import java.util.List;

/**
 * 字典Service接口
 *
 * @author xuyuxiang
 * @date 2022/4/22 10:41
 **/
public interface DevDictService extends IService<DevDict> {

    /**
     * 获取字典分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    Page<DevDict> page(DevDictPageParam devDictPageParam);

    /**
     * 获取字典列表
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    List<DevDict> list(DevDictListParam devDictListParam);

    /**
     * 获取字典树
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    List<Tree<String>> tree(DevDictTreeParam devDictTreeParam);

    /**
     * 添加字典
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:48
     */
    void add(DevDictAddParam devDictAddParam);

    /**
     * 编辑字典
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:13
     */
    void edit(DevDictEditParam devDictEditParam);

    /**
     * 删除字典
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    void delete(List<DevDictIdParam> devDictIdParamList);

    /**
     * 获取字典详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    DevDict detail(DevDictIdParam devDictIdParam);

    /**
     * 获取字典详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    DevDict queryEntity(String id);
}
