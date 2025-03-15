
package vip.xiaonuo.biz.modular.notice.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.biz.modular.notice.entity.BizNotice;
import vip.xiaonuo.biz.modular.notice.param.BizNoticeAddParam;
import vip.xiaonuo.biz.modular.notice.param.BizNoticeEditParam;
import vip.xiaonuo.biz.modular.notice.param.BizNoticeIdParam;
import vip.xiaonuo.biz.modular.notice.param.BizNoticePageParam;
import vip.xiaonuo.biz.modular.notice.service.BizNoticeService;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;

import java.util.List;

/**
 * 通知公告控制器
 *
 * @author yubaoshan
 * @date  2024/07/11 14:46
 */
@Tag(name = "通知公告控制器")
@RestController
@Validated
public class BizNoticeController {

    @Resource
    private BizNoticeService bizNoticeService;

    /**
     * 获取通知公告分页
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    @Operation(summary = "获取通知公告分页")
    @SaCheckPermission("/biz/notice/page")
    @GetMapping("/biz/notice/page")
    public CommonResult<Page<BizNotice>> page(BizNoticePageParam bizNoticePageParam) {
        return CommonResult.data(bizNoticeService.page(bizNoticePageParam));
    }

    /**
     * 添加通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    @Operation(summary = "添加通知公告")
    @CommonLog("添加通知公告")
    @SaCheckPermission("/biz/notice/add")
    @PostMapping("/biz/notice/add")
    public CommonResult<String> add(@RequestBody @Valid BizNoticeAddParam bizNoticeAddParam) {
        bizNoticeService.add(bizNoticeAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    @Operation(summary = "编辑通知公告")
    @CommonLog("编辑通知公告")
    @SaCheckPermission("/biz/notice/edit")
    @PostMapping("/biz/notice/edit")
    public CommonResult<String> edit(@RequestBody @Valid BizNoticeEditParam bizNoticeEditParam) {
        bizNoticeService.edit(bizNoticeEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    @Operation(summary = "删除通知公告")
    @CommonLog("删除通知公告")
    @SaCheckPermission("/biz/notice/delete")
    @PostMapping("/biz/notice/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                   List<BizNoticeIdParam> bizNoticeIdParamList) {
        bizNoticeService.delete(bizNoticeIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取通知公告详情
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    @Operation(summary = "获取通知公告详情")
    @SaCheckPermission("/biz/notice/detail")
    @GetMapping("/biz/notice/detail")
    public CommonResult<BizNotice> detail(@Valid BizNoticeIdParam bizNoticeIdParam) {
        return CommonResult.data(bizNoticeService.detail(bizNoticeIdParam));
    }

    /**
     * 禁用通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    @Operation(summary = "禁用通知公告")
    @CommonLog("禁用通知公告")
    @SaCheckPermission("/biz/notice/disableStatus")
    @PostMapping("/biz/notice/disableStatus")
    public CommonResult<String> disableStatus(@RequestBody @Valid BizNoticeIdParam bizNoticeIdParam) {
        bizNoticeService.disableStatus(bizNoticeIdParam);
        return CommonResult.ok();
    }

    /**
     * 启用通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    @Operation(summary = "启用通知公告")
    @CommonLog("启用通知公告")
    @SaCheckPermission("/biz/notice/enableStatus")
    @PostMapping("/biz/notice/enableStatus")
    public CommonResult<String> enableStatus(@RequestBody @Valid BizNoticeIdParam bizNoticeIdParam) {
        bizNoticeService.enableStatus(bizNoticeIdParam);
        return CommonResult.ok();
    }
}
