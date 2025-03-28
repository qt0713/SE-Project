
package vip.xiaonuo.sys.modular.resource.controller;

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
import vip.xiaonuo.sys.modular.resource.entity.SysModule;
import vip.xiaonuo.sys.modular.resource.param.module.SysModuleAddParam;
import vip.xiaonuo.sys.modular.resource.param.module.SysModuleEditParam;
import vip.xiaonuo.sys.modular.resource.param.module.SysModuleIdParam;
import vip.xiaonuo.sys.modular.resource.param.module.SysModulePageParam;
import vip.xiaonuo.sys.modular.resource.service.SysModuleService;

import java.util.List;

/**
 * 模块控制器
 *
 * @author xuyuxiang
 * @date 2022/6/27 14:12
 **/
@Tag(name = "模块控制器")
@RestController
@Validated
public class SysModuleController {

    @Resource
    private SysModuleService sysModuleService;

    /**
     * 获取模块分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取模块分页")
    @GetMapping("/sys/module/page")
    public CommonResult<Page<SysModule>> page(SysModulePageParam sysModulePageParam) {
        return CommonResult.data(sysModuleService.page(sysModulePageParam));
    }

    /**
     * 添加模块
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "添加模块")
    @CommonLog("添加模块")
    @PostMapping("/sys/module/add")
    public CommonResult<String> add(@RequestBody @Valid SysModuleAddParam sysModuleAddParam) {
        sysModuleService.add(sysModuleAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑模块
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "编辑模块")
    @CommonLog("编辑模块")
    @PostMapping("/sys/module/edit")
    public CommonResult<String> edit(@RequestBody @Valid SysModuleEditParam sysModuleEditParam) {
        sysModuleService.edit(sysModuleEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除模块
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "删除模块")
    @CommonLog("删除模块")
    @PostMapping("/sys/module/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                               List<SysModuleIdParam> sysModuleIdParamList) {
        sysModuleService.delete(sysModuleIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取模块详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取模块详情")
    @GetMapping("/sys/module/detail")
    public CommonResult<SysModule> detail(@Valid SysModuleIdParam sysModuleIdParam) {
        return CommonResult.data(sysModuleService.detail(sysModuleIdParam));
    }
}
