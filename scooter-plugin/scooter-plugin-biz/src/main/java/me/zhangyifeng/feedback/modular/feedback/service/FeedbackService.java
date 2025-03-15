
package me.zhangyifeng.feedback.modular.feedback.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.zhangyifeng.feedback.modular.feedback.entity.Feedback;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackAddParam;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackEditParam;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackIdParam;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackPageParam;

import java.util.List;

/**
 * FeedbackService接口
 *
 * @author 张一风
 * @date  2025/03/10 12:38
 **/
public interface FeedbackService extends IService<Feedback> {

    /**
     * 获取Feedback分页
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    Page<Feedback> page(FeedbackPageParam feedbackPageParam);

    /**
     * 添加Feedback
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    void add(FeedbackAddParam feedbackAddParam);

    /**
     * 编辑Feedback
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    void edit(FeedbackEditParam feedbackEditParam);

    /**
     * 删除Feedback
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    void delete(List<FeedbackIdParam> feedbackIdParamList);

    /**
     * 获取Feedback详情
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     */
    Feedback detail(FeedbackIdParam feedbackIdParam);

    /**
     * 获取Feedback详情
     *
     * @author 张一风
     * @date  2025/03/10 12:38
     **/
    Feedback queryEntity(String id);
}
