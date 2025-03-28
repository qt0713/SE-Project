
package vip.xiaonuo.common.util;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * 过滤器异常工具类，用于处理过滤器中的异常
 * 原理：将异常转发到/errorView进行处理
 *
 * @author xuyuxiang
 * @date 2022/7/18 18:59
 **/
public class CommonFilterExceptionUtil {

    /**
     * 处理过滤器中的异常
     *
     * @author xuyuxiang
     * @date 2022/7/18 19:00
     **/
    public static void handleFilterException(ServletRequest request, ServletResponse response, Exception e) {
        try {
            request.setAttribute("model", e);
            request.getRequestDispatcher("/errorView").forward(request, response);
        } catch (Exception ignored) {
        }
    }
}
