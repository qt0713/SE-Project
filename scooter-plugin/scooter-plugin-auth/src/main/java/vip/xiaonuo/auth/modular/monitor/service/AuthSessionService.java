
package vip.xiaonuo.auth.modular.monitor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import vip.xiaonuo.auth.modular.monitor.param.AuthExitSessionParam;
import vip.xiaonuo.auth.modular.monitor.param.AuthExitTokenParam;
import vip.xiaonuo.auth.modular.monitor.param.AuthSessionPageParam;
import vip.xiaonuo.auth.modular.monitor.result.AuthSessionAnalysisResult;
import vip.xiaonuo.auth.modular.monitor.result.AuthSessionPageResult;

import java.util.List;

/**
 * 会话治理Service接口
 *
 * @author xuyuxiang
 * @date 2022/6/24 15:46S
 **/
public interface AuthSessionService {

    /**
     * 会话统计
     *
     * @author xuyuxiang
     * @date 2022/7/19 9:33
     **/
    AuthSessionAnalysisResult analysis();

    /**
     * 查询B端会话
     *
     * @author xuyuxiang
     * @date 2022/6/24 22:30
     */
    Page<AuthSessionPageResult> pageForB(AuthSessionPageParam authSessionPageParam);

    /**
     * 查询C端会话
     *
     * @author xuyuxiang
     * @date 2022/6/24 22:30
     */
    Page<AuthSessionPageResult> pageForC(AuthSessionPageParam authSessionPageParam);

    /**
     * 强退B端会话
     *
     * @author xuyuxiang
     * @date 2022/6/29 21:47
     */
    void exitSessionForB(List<AuthExitSessionParam> authExitSessionParamList);

    /**
     * 强退C端会话
     *
     * @author xuyuxiang
     * @date 2022/6/29 21:47
     */
    void exitSessionForC(List<AuthExitSessionParam> authExitSessionParamList);

    /**
     * 强退B端token
     *
     * @author xuyuxiang
     * @date 2022/6/29 21:47
     */
    void exitTokenForB(List<AuthExitTokenParam> authExitTokenParamList);

    /**
     * 强退C端token
     *
     * @author xuyuxiang
     * @date 2022/6/29 21:47
     */
    void exitTokenForC(List<AuthExitTokenParam> authExitTokenParamList);
}
