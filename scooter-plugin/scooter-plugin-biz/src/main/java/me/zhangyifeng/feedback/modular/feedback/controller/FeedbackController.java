
package me.zhangyifeng.feedback.modular.feedback.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;
import me.zhangyifeng.feedback.modular.feedback.entity.Feedback;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackAddParam;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackEditParam;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackIdParam;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackPageParam;
import me.zhangyifeng.feedback.modular.feedback.service.FeedbackService;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Feedback控制器
 *
 * @author 张一风
 * @date  2025/03/10 12:38
 */
@Tag(name = "Feedback控制器")
@RestController
@Validated
public class FeedbackController {

    @Resource
    private FeedbackService feedbackService;

    /**
     * 获取Feedback分页
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    @Operation(summary = "获取Feedback分页")
    @SaCheckPermission("/feedback/feedback/page")
    @GetMapping("/feedback/feedback/page")
    public CommonResult<Page<Feedback>> page(FeedbackPageParam feedbackPageParam) {
        return CommonResult.data(feedbackService.page(feedbackPageParam));
    }

    /**
     * 添加Feedback
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    @Operation(summary = "添加Feedback")
    @CommonLog("添加Feedback")
    @SaCheckPermission("/feedback/feedback/add")
    @PostMapping("/feedback/feedback/add")
    public CommonResult<String> add(@RequestBody @Valid FeedbackAddParam feedbackAddParam) {
        feedbackService.add(feedbackAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑Feedback
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    @Operation(summary = "编辑Feedback")
    @CommonLog("编辑Feedback")
    @SaCheckPermission("/feedback/feedback/edit")
    @PostMapping("/feedback/feedback/edit")
    public CommonResult<String> edit(@RequestBody @Valid FeedbackEditParam feedbackEditParam) {
        feedbackService.edit(feedbackEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除Feedback
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    @Operation(summary = "删除Feedback")
    @CommonLog("删除Feedback")
    @SaCheckPermission("/feedback/feedback/delete")
    @PostMapping("/feedback/feedback/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                   List<FeedbackIdParam> feedbackIdParamList) {
        feedbackService.delete(feedbackIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取Feedback详情
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    @Operation(summary = "获取Feedback详情")
    @SaCheckPermission("/feedback/feedback/detail")
    @GetMapping("/feedback/feedback/detail")
    public CommonResult<Feedback> detail(@Valid FeedbackIdParam feedbackIdParam) {
        return CommonResult.data(feedbackService.detail(feedbackIdParam));
    }
}
