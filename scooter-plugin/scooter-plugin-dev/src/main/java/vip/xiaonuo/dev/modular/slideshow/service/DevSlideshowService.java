
package vip.xiaonuo.dev.modular.slideshow.service;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.dev.modular.slideshow.entity.DevSlideshow;
import vip.xiaonuo.dev.modular.slideshow.param.DevSlideshowAddParam;
import vip.xiaonuo.dev.modular.slideshow.param.DevSlideshowEditParam;
import vip.xiaonuo.dev.modular.slideshow.param.DevSlideshowIdParam;
import vip.xiaonuo.dev.modular.slideshow.param.DevSlideshowPageParam;

import java.util.List;

/**
 * 轮播图Service接口
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 **/
public interface DevSlideshowService extends IService<DevSlideshow> {

    /**
     * 获取轮播图分页
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    Page<DevSlideshow> page(DevSlideshowPageParam devSlideshowPageParam);

    /**
     * 添加轮播图
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    void add(DevSlideshowAddParam devSlideshowAddParam);

    /**
     * 编辑轮播图
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    void edit(DevSlideshowEditParam devSlideshowEditParam);

    /**
     * 删除轮播图
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    void delete(List<DevSlideshowIdParam> devSlideshowIdParamList);

    /**
     * 获取轮播图详情
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     **/
    DevSlideshow queryEntity(String id);

    /**
     * 禁用轮播图
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     **/
    void disableStatus(DevSlideshowIdParam devSlideshowIdParam);

    /**
     * 启用轮播图
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     **/
    void enableStatus(DevSlideshowIdParam devSlideshowIdParam);

    /**
     * 通过位置获得轮播图列表
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     **/
    List<JSONObject> getListByPlace(String place);
}
