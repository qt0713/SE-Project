
package me.zhangyifeng.biz.modular.userDiscount.controller;

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
import me.zhangyifeng.biz.modular.userDiscount.entity.UserDiscount;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountAddParam;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountEditParam;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountIdParam;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountPageParam;
import me.zhangyifeng.biz.modular.userDiscount.service.UserDiscountService;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * UserDiscount控制器
 *
 * @author 张一风
 * @date  2025/03/07 23:09
 */
@Tag(name = "UserDiscount控制器")
@RestController
@Validated
public class UserDiscountController {

    @Resource
    private UserDiscountService userDiscountService;

    /**
     * 获取UserDiscount分页
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    @Operation(summary = "获取UserDiscount分页")
    @SaCheckPermission("/biz/userDiscount/page")
    @GetMapping("/biz/userDiscount/page")
    public CommonResult<Page<UserDiscount>> page(UserDiscountPageParam userDiscountPageParam) {
        return CommonResult.data(userDiscountService.page(userDiscountPageParam));
    }

    /**
     * 添加UserDiscount
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    @Operation(summary = "添加UserDiscount")
    @CommonLog("添加UserDiscount")
    @SaCheckPermission("/biz/userDiscount/add")
    @PostMapping("/biz/userDiscount/add")
    public CommonResult<String> add(@RequestBody @Valid UserDiscountAddParam userDiscountAddParam) {
        userDiscountService.add(userDiscountAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑UserDiscount
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    @Operation(summary = "编辑UserDiscount")
    @CommonLog("编辑UserDiscount")
    @SaCheckPermission("/biz/userDiscount/edit")
    @PostMapping("/biz/userDiscount/edit")
    public CommonResult<String> edit(@RequestBody @Valid UserDiscountEditParam userDiscountEditParam) {
        userDiscountService.edit(userDiscountEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除UserDiscount
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    @Operation(summary = "删除UserDiscount")
    @CommonLog("删除UserDiscount")
    @SaCheckPermission("/biz/userDiscount/delete")
    @PostMapping("/biz/userDiscount/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                   List<UserDiscountIdParam> userDiscountIdParamList) {
        userDiscountService.delete(userDiscountIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取UserDiscount详情
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    @Operation(summary = "获取UserDiscount详情")
    @SaCheckPermission("/biz/userDiscount/detail")
    @GetMapping("/biz/userDiscount/detail")
    public CommonResult<UserDiscount> detail(@Valid UserDiscountIdParam userDiscountIdParam) {
        return CommonResult.data(userDiscountService.detail(userDiscountIdParam));
    }
}
