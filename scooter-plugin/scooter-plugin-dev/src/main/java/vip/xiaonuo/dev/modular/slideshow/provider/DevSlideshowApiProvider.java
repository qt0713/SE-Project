
package vip.xiaonuo.dev.modular.slideshow.provider;

import cn.hutool.json.JSONObject;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import vip.xiaonuo.dev.api.DevSlideshowApi;
import vip.xiaonuo.dev.modular.slideshow.service.DevSlideshowService;

import java.util.List;

/**
 * 轮播图API接口实现类
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 */
@Service
public class DevSlideshowApiProvider implements DevSlideshowApi {

    @Resource
    private DevSlideshowService devSlideshowService;

    @Override
    public List<JSONObject> getListByPlace(String place) {
        return devSlideshowService.getListByPlace(place);
    }
}
