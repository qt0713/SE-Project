
package vip.xiaonuo.dev.modular.job.controller;

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
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;
import vip.xiaonuo.dev.modular.job.entity.DevJob;
import vip.xiaonuo.dev.modular.job.param.*;
import vip.xiaonuo.dev.modular.job.service.DevJobService;

import java.util.List;

/**
 * 定时任务控制器
 *
 * @author xuyuxiang
 * @date 2022/8/5 10:48
 **/
@Tag(name = "定时任务控制器")
@RestController
@Validated
public class DevJobController {

    @Resource
    private DevJobService devJobService;
    
    /**
     * 获取定时任务分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取定时任务分页")
    @GetMapping("/dev/job/page")
    public CommonResult<Page<DevJob>> page(DevJobPageParam devJobPageParam) {
        return CommonResult.data(devJobService.page(devJobPageParam));
    }

    /**
     * 获取定时任务列表
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取定时任务列表")
    @GetMapping("/dev/job/list")
    public CommonResult<List<DevJob>> list(DevJobListParam devJobListParam) {
        return CommonResult.data(devJobService.list(devJobListParam));
    }

    /**
     * 添加定时任务
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "添加定时任务")
    @CommonLog("添加定时任务")
    @PostMapping("/dev/job/add")
    public CommonResult<String> add(@RequestBody @Valid DevJobAddParam devJobAddParam) {
        devJobService.add(devJobAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑定时任务
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "编辑定时任务")
    @CommonLog("编辑定时任务")
    @PostMapping("/dev/job/edit")
    public CommonResult<String> edit(@RequestBody @Valid DevJobEditParam devJobEditParam) {
        devJobService.edit(devJobEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除定时任务
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "删除定时任务")
    @CommonLog("删除定时任务")
    @PostMapping("/dev/job/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                               List<DevJobIdParam> devJobIdParamList) {
        devJobService.delete(devJobIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取定时任务详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取定时任务详情")
    @GetMapping("/dev/job/detail")
    public CommonResult<DevJob> detail(@Valid DevJobIdParam devJobIdParam) {
        return CommonResult.data(devJobService.detail(devJobIdParam));
    }

    /**
     * 停止定时任务
     *
     * @author xuyuxiang
     * @date 2021/10/13 14:01
     **/
    @Operation(summary = "停止定时任务")
    @CommonLog("停止定时任务")
    @PostMapping("/dev/job/stopJob")
    public CommonResult<String> stopJob(@RequestBody DevJobIdParam devJobIdParam) {
        devJobService.stopJob(devJobIdParam);
        return CommonResult.ok();
    }

    /**
     * 运行定时任务
     *
     * @author xuyuxiang
     * @date 2021/10/13 14:01
     **/
    @Operation(summary = "运行定时任务")
    @CommonLog("运行定时任务")
    @PostMapping("/dev/job/runJob")
    public CommonResult<String> runJob(@RequestBody @Valid DevJobIdParam devJobIdParam) {
        devJobService.runJob(devJobIdParam);
        return CommonResult.ok();
    }

    /**
     * 立即运行定时任务
     *
     * @author xuyuxiang
     * @date 2021/10/13 14:01
     **/
    @Operation(summary = "立即运行定时任务")
    @CommonLog("立即运行定时任务")
    @PostMapping("/dev/job/runJobNow")
    public CommonResult<String> runJobNow(@RequestBody @Valid DevJobIdParam devJobIdParam) {
        devJobService.runJobNow(devJobIdParam);
        return CommonResult.ok();
    }

    /**
     * 获取定时任务类
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取定时任务类")
    @GetMapping("/dev/job/getActionClass")
    public CommonResult<List<String>> getActionClass() {
        return CommonResult.data(devJobService.getActionClass());
    }
}
