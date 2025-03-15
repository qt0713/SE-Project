
package vip.xiaonuo.core.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.xiaonuo.common.pojo.CommonResult;

/**
 * 全局异常处理器
 *
 * @author xuyuxiang
 * @date 2021/10/9 14:59
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 不同异常返回不同结果
     *
     * @author xuyuxiang
     * @date 2022/7/28 16:54
     **/
    @ResponseBody
    @ExceptionHandler
    public CommonResult<String> handleException(Exception e) {
        return GlobalExceptionUtil.getCommonResult(e);
    }
}
