
package vip.xiaonuo.biz.modular.notice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.biz.modular.notice.entity.BizNotice;
import vip.xiaonuo.biz.modular.notice.param.BizNoticeAddParam;
import vip.xiaonuo.biz.modular.notice.param.BizNoticeEditParam;
import vip.xiaonuo.biz.modular.notice.param.BizNoticeIdParam;
import vip.xiaonuo.biz.modular.notice.param.BizNoticePageParam;

import java.util.List;

/**
 * 通知公告Service接口
 *
 * @author yubaoshan
 * @date  2024/07/11 14:46
 **/
public interface BizNoticeService extends IService<BizNotice> {

    /**
     * 获取通知公告分页
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    Page<BizNotice> page(BizNoticePageParam bizNoticePageParam);

    /**
     * 添加通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    void add(BizNoticeAddParam bizNoticeAddParam);

    /**
     * 编辑通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    void edit(BizNoticeEditParam bizNoticeEditParam);

    /**
     * 删除通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    void delete(List<BizNoticeIdParam> bizNoticeIdParamList);

    /**
     * 获取通知公告详情
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    BizNotice detail(BizNoticeIdParam bizNoticeIdParam);

    /**
     * 获取通知公告详情
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     **/
    BizNotice queryEntity(String id);

    /**
     * 禁用通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    void disableStatus(BizNoticeIdParam bizNoticeIdParam);

    /**
     * 启用通知公告
     *
     * @author yubaoshan
     * @date  2024/07/11 14:46
     */
    void enableStatus(BizNoticeIdParam bizNoticeIdParam);
}
