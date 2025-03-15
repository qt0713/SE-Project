
package vip.xiaonuo.biz.modular.index.service;

import jakarta.validation.Valid;
import vip.xiaonuo.biz.modular.index.param.BizIndexNoticeIdParam;
import vip.xiaonuo.biz.modular.index.param.BizIndexNoticeListParam;
import vip.xiaonuo.biz.modular.index.param.BizIndexSlideshowListParam;
import vip.xiaonuo.biz.modular.index.result.BizIndexNoticeListResult;
import vip.xiaonuo.biz.modular.index.result.BizIndexSlideshowDetailResult;
import vip.xiaonuo.biz.modular.index.result.BizIndexSlideshowListResult;

import java.util.List;

/**
 * 业务首页Service接口
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 */
public interface BizIndexService {

    /**
     * 获取轮播图列表
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    List<BizIndexSlideshowListResult> slideshowListByPlace(BizIndexSlideshowListParam bizIndexSlideshowListParam);

    /**
     * 获取通知公告列表
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    List<BizIndexNoticeListResult> noticeListByLimit(@Valid BizIndexNoticeListParam bizIndexNoticeListParam);

    /**
     * 获取通知公告详情
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    BizIndexSlideshowDetailResult noticeDetailById(BizIndexNoticeIdParam bizIndexNoticeIdParam);
}
