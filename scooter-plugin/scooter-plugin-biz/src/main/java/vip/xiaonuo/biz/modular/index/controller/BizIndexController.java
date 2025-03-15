
package vip.xiaonuo.biz.modular.index.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.biz.modular.index.param.BizIndexNoticeIdParam;
import vip.xiaonuo.biz.modular.index.param.BizIndexNoticeListParam;
import vip.xiaonuo.biz.modular.index.param.BizIndexSlideshowListParam;
import vip.xiaonuo.biz.modular.index.result.BizIndexNoticeListResult;
import vip.xiaonuo.biz.modular.index.result.BizIndexSlideshowDetailResult;
import vip.xiaonuo.biz.modular.index.result.BizIndexSlideshowListResult;
import vip.xiaonuo.biz.modular.index.service.BizIndexService;
import vip.xiaonuo.common.pojo.CommonResult;

import java.util.List;

/**
 * 业务首页控制器
 *
 * @author yubaoshan
 * @date 2024/7/13 21:02
 */
@Tag(name = "业务首页控制器")
@ApiSupport(author = "SNOWY_TEAM", order = 0)
@RestController
@Validated
public class BizIndexController {

    @Resource
    private BizIndexService bizIndexService;

    /**
     * 获取轮播图列表
     *
     * @author yubaoshan
     * @date 2024/7/13 21:02
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "获取轮播图列表")
    @GetMapping("/biz/index/slideshow/list")
    public CommonResult<List<BizIndexSlideshowListResult>> slideshowListByPlace(@Valid BizIndexSlideshowListParam bizIndexSlideshowListParam) {
        return CommonResult.data(bizIndexService.slideshowListByPlace(bizIndexSlideshowListParam));
    }

    /**
     * 获取通知公告列表
     *
     * @author yubaoshan
     * @date 2024/7/13 21:02
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "获取通知公告列表")
    @GetMapping("/biz/index/notice/list")
    public CommonResult<List<BizIndexNoticeListResult>> noticeListByLimit(BizIndexNoticeListParam bizIndexNoticeListParam) {
        return CommonResult.data(bizIndexService.noticeListByLimit(bizIndexNoticeListParam));
    }

    /**
     * 获取通知公告详情
     *
     * @author yubaoshan
     * @date 2024/7/13 21:02
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "获取通知公告详情")
    @GetMapping("/biz/index/notice/detail")
    public CommonResult<BizIndexSlideshowDetailResult> noticeDetailById(@Valid BizIndexNoticeIdParam bizIndexNoticeIdParam) {
        return CommonResult.data(bizIndexService.noticeDetailById(bizIndexNoticeIdParam));
    }
}
