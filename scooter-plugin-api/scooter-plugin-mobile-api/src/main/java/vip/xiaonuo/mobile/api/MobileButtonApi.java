
package vip.xiaonuo.mobile.api;

import java.util.List;

/**
 * 移动端按钮API
 *
 * @author xuyuxiang
 * @date 2023/2/1 9:52
 **/
public interface MobileButtonApi {

    /**
     * 根据按钮id集合获取按钮码列表
     *
     * @author 每天一点
     * @date 2023/2/5 13:26
     **/
    List<String> listByIds(List<String> idList);
}
