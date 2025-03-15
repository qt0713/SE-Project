
package vip.xiaonuo.sys.modular.resource.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.sys.modular.resource.entity.SysButton;
import vip.xiaonuo.sys.modular.resource.param.button.SysButtonAddParam;
import vip.xiaonuo.sys.modular.resource.param.button.SysButtonEditParam;
import vip.xiaonuo.sys.modular.resource.param.button.SysButtonIdParam;
import vip.xiaonuo.sys.modular.resource.param.button.SysButtonPageParam;

import java.util.List;

/**
 * 按钮Service接口
 *
 * @author xuyuxiang
 * @date 2022/6/27 14:01
 **/
public interface SysButtonService extends IService<SysButton> {

    /**
     * 获取按钮分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    Page<SysButton> page(SysButtonPageParam sysButtonPageParam);

    /**
     * 添加按钮
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:48
     */
    void add(SysButtonAddParam sysButtonAddParam);

    /**
     * 代码生成按钮插入
     *
     * @author xuyuxiang
     * @date 2022/11/1 15:34
     * @return java.lang.String
     **/
    void addForGenButton(String menuId, String className, String functionName);

    /**
     * 编辑按钮
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:13
     */
    void edit(SysButtonEditParam sysButtonEditParam);

    /**
     * 删除按钮
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    void delete(List<SysButtonIdParam> sysButtonIdParamList);

    /**
     * 获取按钮详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    SysButton detail(SysButtonIdParam sysButtonIdParam);

    /**
     * 获取按钮详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    SysButton queryEntity(String id);
}
