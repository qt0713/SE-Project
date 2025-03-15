
package vip.xiaonuo.mobile.modular.resource.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.mobile.modular.resource.entity.MobileButton;
import vip.xiaonuo.mobile.modular.resource.param.button.MobileButtonAddParam;
import vip.xiaonuo.mobile.modular.resource.param.button.MobileButtonEditParam;
import vip.xiaonuo.mobile.modular.resource.param.button.MobileButtonIdParam;
import vip.xiaonuo.mobile.modular.resource.param.button.MobileButtonPageParam;

import java.util.List;

/**
 * 移动端按钮Service接口
 *
 * @author xuyuxiang
 * @date 2022/6/27 14:01
 **/
public interface MobileButtonService extends IService<MobileButton> {

    /**
     * 获取移动端按钮分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:08
     */
    Page<MobileButton> page(MobileButtonPageParam mobileButtonPageParam);

    /**
     * 添加移动端按钮
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:48
     */
    void add(MobileButtonAddParam mobileButtonAddParam);

    /**
     * 编辑移动端按钮
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:13
     */
    void edit(MobileButtonEditParam mobileButtonEditParam);

    /**
     * 删除移动端按钮
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    void delete(List<MobileButtonIdParam> mobileButtonIdParamList);

    /**
     * 获取移动端按钮详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    MobileButton detail(MobileButtonIdParam mobileButtonIdParam);

    /**
     * 获取移动端按钮详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 21:18
     */
    MobileButton queryEntity(String id);
}
