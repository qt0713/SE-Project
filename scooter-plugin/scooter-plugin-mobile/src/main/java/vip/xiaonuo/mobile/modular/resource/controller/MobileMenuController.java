
package vip.xiaonuo.mobile.modular.resource.controller;

import cn.hutool.core.lang.tree.Tree;
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
import vip.xiaonuo.mobile.modular.resource.entity.MobileMenu;
import vip.xiaonuo.mobile.modular.resource.entity.MobileModule;
import vip.xiaonuo.mobile.modular.resource.param.menu.*;
import vip.xiaonuo.mobile.modular.resource.service.MobileMenuService;

import java.util.List;

/**
 * 移动端菜单控制器
 *
 * @author yubaoshan
 * @date  2023/01/28 22:42
 */
@Tag(name = "移动端菜单控制器")
@RestController
@Validated
public class MobileMenuController {

    @Resource
    private MobileMenuService mobileMenuService;

    /**
     * 获取移动端菜单tree
     *
     * @author yubaoshan
     * @date  2023/01/28 22:42
     */
    @Operation(summary = "获取移动端菜单tree")
    @GetMapping("/mobile/menu/tree")
    public CommonResult<List<Tree<String>>> tree(MobileMenuTreeParam mobileMenuTreeParam) {
        return CommonResult.data(mobileMenuService.tree(mobileMenuTreeParam));
    }

    /**
     * 添加移动端菜单
     *
     * @author yubaoshan
     * @date  2023/01/28 22:42
     */
    @Operation(summary = "添加移动端菜单")
    @CommonLog("添加移动端菜单")
    @PostMapping("/mobile/menu/add")
    public CommonResult<String> add(@RequestBody @Valid MobileMenuAddParam mobileMenuAddParam) {
        mobileMenuService.add(mobileMenuAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑移动端菜单
     *
     * @author yubaoshan
     * @date  2023/01/28 22:42
     */
    @Operation(summary = "编辑移动端菜单")
    @CommonLog("编辑移动端菜单")
    @PostMapping("/mobile/menu/edit")
    public CommonResult<String> edit(@RequestBody @Valid MobileMenuEditParam mobileMenuEditParam) {
        mobileMenuService.edit(mobileMenuEditParam);
        return CommonResult.ok();
    }

    /**
     * 更改移动端菜单所属模块
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @Operation(summary = "更改移动端菜单所属模块")
    @CommonLog("更改移动端菜单所属模块")
    @PostMapping("/mobile/menu/changeModule")
    public CommonResult<String> changeModule(@RequestBody @Valid MobileMenuChangeModuleParam mobileMenuChangeModuleParam) {
        mobileMenuService.changeModule(mobileMenuChangeModuleParam);
        return CommonResult.ok();
    }

    /**
     * 删除移动端菜单
     *
     * @author yubaoshan
     * @date  2023/01/28 22:42
     */
    @Operation(summary = "删除移动端菜单")
    @CommonLog("删除移动端菜单")
    @PostMapping("/mobile/menu/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                                   List<MobileMenuIdParam> mobileMenuIdParamList) {
        mobileMenuService.delete(mobileMenuIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取移动端菜单详情
     *
     * @author yubaoshan
     * @date  2023/01/28 22:42
     */
    @Operation(summary = "获取移动端菜单详情")
    @GetMapping("/mobile/menu/detail")
    public CommonResult<MobileMenu> detail(@Valid MobileMenuIdParam mobileMenuIdParam) {
        return CommonResult.data(mobileMenuService.detail(mobileMenuIdParam));
    }

    /* ====菜单部分所需要用到的选择器==== */

    /**
     * 获取模块选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取模块选择器")
    @GetMapping("/mobile/menu/moduleSelector")
    public CommonResult<List<MobileModule>> moduleSelector(MobileMenuSelectorModuleParam mobileMenuSelectorModuleParam) {
        return CommonResult.data(mobileMenuService.moduleSelector(mobileMenuSelectorModuleParam));
    }

    /**
     * 获取菜单树选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @Operation(summary = "获取菜单树选择器")
    @GetMapping("/mobile/menu/menuTreeSelector")
    public CommonResult<List<Tree<String>>> menuTreeSelector(MobileMenuSelectorMenuParam mobileMenuSelectorMenuParam) {
        return CommonResult.data(mobileMenuService.menuTreeSelector(mobileMenuSelectorMenuParam));
    }
}
