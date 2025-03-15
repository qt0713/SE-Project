
package me.zhangyifeng.biz.modular.rentalOption.controller;

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
import me.zhangyifeng.biz.modular.rentalOption.entity.RentalOption;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionAddParam;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionEditParam;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionIdParam;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionPageParam;
import me.zhangyifeng.biz.modular.rentalOption.service.RentalOptionService;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * RentalOption控制器
 *
 * @author 张一风
 * @date  2025/03/07 22:56
 */
@Tag(name = "RentalOption控制器")
@RestController
@Validated
public class RentalOptionController {

    @Resource
    private RentalOptionService rentalOptionService;

    /**
     * 获取RentalOption分页
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    @Operation(summary = "获取RentalOption分页")
    @SaCheckPermission("/biz/rentalOption/page")
    @GetMapping("/biz/rentalOption/page")
    public CommonResult<Page<RentalOption>> page(RentalOptionPageParam rentalOptionPageParam) {
        return CommonResult.data(rentalOptionService.page(rentalOptionPageParam));
    }

    /**
     * 添加RentalOption
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    @Operation(summary = "添加RentalOption")
    @CommonLog("添加RentalOption")
    @SaCheckPermission("/biz/rentalOption/add")
    @PostMapping("/biz/rentalOption/add")
    public CommonResult<String> add(@RequestBody @Valid RentalOptionAddParam rentalOptionAddParam) {
        rentalOptionService.add(rentalOptionAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑RentalOption
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    @Operation(summary = "编辑RentalOption")
    @CommonLog("编辑RentalOption")
    @SaCheckPermission("/biz/rentalOption/edit")
    @PostMapping("/biz/rentalOption/edit")
    public CommonResult<String> edit(@RequestBody @Valid RentalOptionEditParam rentalOptionEditParam) {
        rentalOptionService.edit(rentalOptionEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除RentalOption
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    @Operation(summary = "删除RentalOption")
    @CommonLog("删除RentalOption")
    @SaCheckPermission("/biz/rentalOption/delete")
    @PostMapping("/biz/rentalOption/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                   List<RentalOptionIdParam> rentalOptionIdParamList) {
        rentalOptionService.delete(rentalOptionIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取RentalOption详情
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    @Operation(summary = "获取RentalOption详情")
    @SaCheckPermission("/biz/rentalOption/detail")
    @GetMapping("/biz/rentalOption/detail")
    public CommonResult<RentalOption> detail(@Valid RentalOptionIdParam rentalOptionIdParam) {
        return CommonResult.data(rentalOptionService.detail(rentalOptionIdParam));
    }
}
