
package me.zhangyifeng.biz.modular.scooter.controller;

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
import me.zhangyifeng.biz.modular.scooter.entity.Scooter;
import me.zhangyifeng.biz.modular.scooter.param.ScooterAddParam;
import me.zhangyifeng.biz.modular.scooter.param.ScooterEditParam;
import me.zhangyifeng.biz.modular.scooter.param.ScooterIdParam;
import me.zhangyifeng.biz.modular.scooter.param.ScooterPageParam;
import me.zhangyifeng.biz.modular.scooter.service.ScooterService;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Scooter控制器
 *
 * @author 张一风
 * @date  2025/03/07 22:51
 */
@Tag(name = "Scooter控制器")
@RestController
@Validated
public class ScooterController {

    @Resource
    private ScooterService scooterService;

    /**
     * 获取Scooter分页
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    @Operation(summary = "获取Scooter分页")
    @SaCheckPermission("/biz/scooter/page")
    @GetMapping("/biz/scooter/page")
    public CommonResult<Page<Scooter>> page(ScooterPageParam scooterPageParam) {
        return CommonResult.data(scooterService.page(scooterPageParam));
    }

    /**
     * 添加Scooter
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    @Operation(summary = "添加Scooter")
    @CommonLog("添加Scooter")
    @SaCheckPermission("/biz/scooter/add")
    @PostMapping("/biz/scooter/add")
    public CommonResult<String> add(@RequestBody @Valid ScooterAddParam scooterAddParam) {
        scooterService.add(scooterAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑Scooter
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    @Operation(summary = "编辑Scooter")
    @CommonLog("编辑Scooter")
    @SaCheckPermission("/biz/scooter/edit")
    @PostMapping("/biz/scooter/edit")
    public CommonResult<String> edit(@RequestBody @Valid ScooterEditParam scooterEditParam) {
        scooterService.edit(scooterEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除Scooter
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    @Operation(summary = "删除Scooter")
    @CommonLog("删除Scooter")
    @SaCheckPermission("/biz/scooter/delete")
    @PostMapping("/biz/scooter/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                   List<ScooterIdParam> scooterIdParamList) {
        scooterService.delete(scooterIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取Scooter详情
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    @Operation(summary = "获取Scooter详情")
    @SaCheckPermission("/biz/scooter/detail")
    @GetMapping("/biz/scooter/detail")
    public CommonResult<Scooter> detail(@Valid ScooterIdParam scooterIdParam) {
        return CommonResult.data(scooterService.detail(scooterIdParam));
    }
}
