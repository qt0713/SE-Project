
package me.zhangyifeng.biz.modular.creditcard.controller;

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
import me.zhangyifeng.biz.modular.creditcard.entity.Creditcard;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardAddParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardEditParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardIdParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardPageParam;
import me.zhangyifeng.biz.modular.creditcard.service.CreditcardService;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * CreditCard控制器
 *
 * @author 张一风
 * @date  2025/03/09 11:38
 */
@Tag(name = "CreditCard控制器")
@RestController
@Validated
public class CreditcardController {

    @Resource
    private CreditcardService creditcardService;

    /**
     * 获取CreditCard分页
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    @Operation(summary = "获取CreditCard分页")
    @SaCheckPermission("/biz/creditcard/page")
    @GetMapping("/biz/creditcard/page")
    public CommonResult<Page<Creditcard>> page(CreditcardPageParam creditcardPageParam) {
        return CommonResult.data(creditcardService.page(creditcardPageParam));
    }

    /**
     * 添加CreditCard
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    @Operation(summary = "添加CreditCard")
    @CommonLog("添加CreditCard")
    @SaCheckPermission("/biz/creditcard/add")
    @PostMapping("/biz/creditcard/add")
    public CommonResult<String> add(@RequestBody @Valid CreditcardAddParam creditcardAddParam) {
        creditcardService.add(creditcardAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑CreditCard
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    @Operation(summary = "编辑CreditCard")
    @CommonLog("编辑CreditCard")
    @SaCheckPermission("/biz/creditcard/edit")
    @PostMapping("/biz/creditcard/edit")
    public CommonResult<String> edit(@RequestBody @Valid CreditcardEditParam creditcardEditParam) {
        creditcardService.edit(creditcardEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除CreditCard
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    @Operation(summary = "删除CreditCard")
    @CommonLog("删除CreditCard")
    @SaCheckPermission("/biz/creditcard/delete")
    @PostMapping("/biz/creditcard/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                   List<CreditcardIdParam> creditcardIdParamList) {
        creditcardService.delete(creditcardIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取CreditCard详情
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    @Operation(summary = "获取CreditCard详情")
    @SaCheckPermission("/biz/creditcard/detail")
    @GetMapping("/biz/creditcard/detail")
    public CommonResult<Creditcard> detail(@Valid CreditcardIdParam creditcardIdParam) {
        return CommonResult.data(creditcardService.detail(creditcardIdParam));
    }
}
