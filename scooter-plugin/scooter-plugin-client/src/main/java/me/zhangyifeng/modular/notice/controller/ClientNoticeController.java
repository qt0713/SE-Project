package me.zhangyifeng.modular.notice.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.biz.modular.notice.entity.BizNotice;
import vip.xiaonuo.biz.modular.notice.param.BizNoticePageParam;
import vip.xiaonuo.biz.modular.notice.service.BizNoticeService;
import vip.xiaonuo.common.pojo.CommonResult;
import vip.xiaonuo.dev.modular.slideshow.entity.DevSlideshow;
import vip.xiaonuo.dev.modular.slideshow.param.DevSlideshowPageParam;
import vip.xiaonuo.dev.modular.slideshow.service.DevSlideshowService;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/9 13:29
 * @version: 1.0
 */

@RestController
@Tag(name = "面向用户的公告")
@RequestMapping("/client/notice")
public class ClientNoticeController {
    @Resource
    private BizNoticeService bizNoticeService;
    @Resource
    private DevSlideshowService slideShowService;

    /**
     * 获取通知公告分页
     *
     * @author yubaoshan
     * @date 2024/07/11 14:46
     */
    @Operation(summary = "获取通知公告分页")
    @GetMapping("/page")
    public CommonResult<Page<BizNotice>> page(BizNoticePageParam clientNoticePageParam) {
        clientNoticePageParam.setPlace("CLIENT_MOBILE");
        clientNoticePageParam.setStatus("ENABLE");
        return CommonResult.data(bizNoticeService.page(clientNoticePageParam));
    }

    @Operation(summary = "获取通知详情")
    @GetMapping("/detail")
    public CommonResult<BizNotice> detail( String id) {
        BizNotice notice = bizNoticeService.getById(id);
        return CommonResult.data(notice);
    }

    @Operation(summary = "获取幻灯片")
    @GetMapping("/pic/page")
    public CommonResult<Page<DevSlideshow>> pic(DevSlideshowPageParam devSlideshowPageParam) {
        devSlideshowPageParam.setPlace("CLIENT_MOBILE");
        devSlideshowPageParam.setStatus("ENABLE");
        return CommonResult.data(slideShowService.page(devSlideshowPageParam));
    }
}
