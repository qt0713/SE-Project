
package vip.xiaonuo.auth.modular.login.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaonuo.auth.core.annotation.SaClientCheckLogin;
import vip.xiaonuo.auth.core.enums.SaClientTypeEnum;
import vip.xiaonuo.auth.core.pojo.SaBaseClientLoginUser;
import vip.xiaonuo.auth.core.util.StpClientUtil;
import vip.xiaonuo.auth.modular.login.param.AuthAccountPasswordLoginParam;
import vip.xiaonuo.auth.modular.login.param.AuthGetPhoneValidCodeParam;
import vip.xiaonuo.auth.modular.login.param.AuthPhoneValidCodeLoginParam;
import vip.xiaonuo.auth.modular.login.result.AuthPicValidCodeResult;
import vip.xiaonuo.auth.modular.login.service.AuthService;
import vip.xiaonuo.common.pojo.CommonResult;

/**
 * C端登录控制器
 *
 * @author xuyuxiang
 * @date 2021/12/23 21:50
 */
@Tag(name = "C端登录控制器")
@RestController
@Validated
public class AuthClientController {

    @Resource
    private AuthService authService;

    /**
     * C端获取图片验证码
     *
     * @author xuyuxiang
     * @date 2022/7/8 9:26
     **/
    @Operation(summary = "C端获取图片验证码")
    @GetMapping("/auth/c/getPicCaptcha")
    public CommonResult<AuthPicValidCodeResult> getPicCaptcha() {
        return CommonResult.data(authService.getPicCaptcha(SaClientTypeEnum.C.getValue()));
    }

    /**
     * C端获取手机验证码
     *
     * @author xuyuxiang
     * @date 2022/7/8 9:26
     **/
    @Operation(summary = "C端获取手机验证码")
    @GetMapping("/auth/c/getPhoneValidCode")
    public CommonResult<String> getPhoneValidCode(@Valid AuthGetPhoneValidCodeParam authGetPhoneValidCodeParam) {
        return CommonResult.data(authService.getPhoneValidCode(authGetPhoneValidCodeParam, SaClientTypeEnum.C.getValue()));
    }

    /**
     * C端账号密码登录
     *
     * @author xuyuxiang
     * @date 2021/10/15 13:12
     **/
    @Operation(summary = "C端账号密码登录")
    @PostMapping("/auth/c/doLogin")
    public CommonResult<String> doLogin(@RequestBody @Valid AuthAccountPasswordLoginParam authAccountPasswordLoginParam) {
        return CommonResult.data(authService.doLogin(authAccountPasswordLoginParam, SaClientTypeEnum.C.getValue()));
    }

    /**
     * C端手机验证码登录
     *
     * @author xuyuxiang
     * @date 2021/10/15 13:12
     **/
    @Operation(summary = "C端手机验证码登录")
    @PostMapping("/auth/c/doLoginByPhone")
    public CommonResult<String> doLoginByPhone(@RequestBody @Valid AuthPhoneValidCodeLoginParam authPhoneValidCodeLoginParam) {
        return CommonResult.data(authService.doLoginByPhone(authPhoneValidCodeLoginParam, SaClientTypeEnum.C.getValue()));
    }

    /**
     * C端退出
     *
     * @author xuyuxiang
     * @date 2021/10/15 13:12
     **/
    @Operation(summary = "C端退出")
    @SaClientCheckLogin
    @GetMapping("/auth/c/doLogout")
    public CommonResult<String> doLogout() {
        StpClientUtil.logout();
        return CommonResult.ok();
    }

    /**
     * C端获取用户信息
     *
     * @author xuyuxiang
     * @date 2021/10/15 13:12
     **/
    @Operation(summary = "C端获取用户信息")
    @SaClientCheckLogin
    @GetMapping("/auth/c/getLoginUser")
    public CommonResult<SaBaseClientLoginUser> getLoginUser() {
        return CommonResult.data(authService.getClientLoginUser());
    }
}
