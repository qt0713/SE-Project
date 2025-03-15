package me.zhangyifeng.modular.creditCard;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import me.zhangyifeng.biz.modular.creditcard.entity.Creditcard;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardAddParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardEditParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardIdParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardPageParam;
import org.springframework.web.bind.annotation.*;
import vip.xiaonuo.auth.core.util.StpClientUtil;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;
import me.zhangyifeng.biz.modular.creditcard.service.CreditcardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/9 11:20
 * @version: 1.0
 */

@RestController
@RequestMapping("/client/creditCard")
@Tag(name = "信用卡模块")
public class ClientCreditCardController {
    @Resource
    private CreditcardService creditcardService;

    /**
     * 获取CreditCard分页
     *
     * @author 张一风
     * @date 2025/03/09 11:11
     */
    @Operation(summary = "获取CreditCard分页")
    @GetMapping("/page")
    public CommonResult<Page<Creditcard>> page(CreditcardPageParam creditcardPageParam) {
        creditcardPageParam.setUserId(StpClientUtil.getLoginIdAsString());
        return CommonResult.data(creditcardService.page(creditcardPageParam));
    }

    /**
     * 添加CreditCard
     *
     * @author 张一风
     * @date 2025/03/09 11:38
     */
    @Operation(summary = "添加CreditCard")
    @CommonLog("添加CreditCard")
    @PostMapping("/add")
    public CommonResult<String> add(@RequestBody @Valid CreditcardAddParam creditcardAddParam) {
        creditcardAddParam.setUserId(StpClientUtil.getLoginIdAsString());
        // 判断是否已经有默认的卡了
        if (creditcardAddParam.getIsDefault() == 1) {
            QueryWrapper<Creditcard> wrapper = new QueryWrapper<>();
            List<Creditcard> creditcards = creditcardService.list(wrapper.eq("user_id", StpClientUtil.getLoginIdAsString()));
            for (Creditcard credit : creditcards) {
                if (credit.getIsDefault() == 1) {
                    credit.setIsDefault(0);
                    creditcardService.save(credit);
                    break;
                }
            }
        }

        creditcardService.add(creditcardAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑CreditCard
     *
     * @author 张一风
     * @date 2025/03/09 11:38
     */
    @Operation(summary = "编辑CreditCard")
    @CommonLog("编辑CreditCard")
    @PostMapping("/edit")
    public CommonResult<String> edit(@RequestBody @Valid CreditcardEditParam creditcardEditParam) {
        creditcardEditParam.setUserId(StpClientUtil.getLoginIdAsString());
        if (creditcardEditParam.getIsDefault() == 1) {
            QueryWrapper<Creditcard> wrapper = new QueryWrapper<>();
            List<Creditcard> creditcards = creditcardService.list(wrapper.eq("user_id", StpClientUtil.getLoginIdAsString()));
            for (Creditcard credit : creditcards) {
                if (credit.getIsDefault() == 1) {
                    credit.setIsDefault(0);
                    creditcardService.saveOrUpdate(credit);
                    break;
                }
            }
        }
        creditcardService.edit(creditcardEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除CreditCard
     *
     * @author 张一风
     * @date 2025/03/09 11:38
     */
    @Operation(summary = "删除CreditCard")
    @CommonLog("删除CreditCard")
    @PostMapping("/delete")
    public CommonResult<String> delete(@RequestParam String id) {
        if (creditcardService.getById(id).getUserId().equalsIgnoreCase(StpClientUtil.getLoginIdAsString())) {
            return CommonResult.data("It's not your Card!");
        }
        creditcardService.removeById(id);
        return CommonResult.ok();
    }

}
