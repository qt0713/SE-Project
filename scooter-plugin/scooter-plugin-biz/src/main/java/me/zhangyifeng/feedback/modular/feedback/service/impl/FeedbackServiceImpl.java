
package me.zhangyifeng.feedback.modular.feedback.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.xiaonuo.common.enums.CommonSortOrderEnum;
import vip.xiaonuo.common.exception.CommonException;
import vip.xiaonuo.common.page.CommonPageRequest;
import me.zhangyifeng.feedback.modular.feedback.entity.Feedback;
import me.zhangyifeng.feedback.modular.feedback.mapper.FeedbackMapper;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackAddParam;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackEditParam;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackIdParam;
import me.zhangyifeng.feedback.modular.feedback.param.FeedbackPageParam;
import me.zhangyifeng.feedback.modular.feedback.service.FeedbackService;

import java.util.List;

/**
 * FeedbackService接口实现类
 *
 * @author 张一风
 * @date  2025/03/10 12:38
 **/
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Override
    public Page<Feedback> page(FeedbackPageParam feedbackPageParam) {
        QueryWrapper<Feedback> queryWrapper = new QueryWrapper<Feedback>().checkSqlInjection();
        if(ObjectUtil.isNotEmpty(feedbackPageParam.getUserId())) {
            queryWrapper.lambda().like(Feedback::getUserId, feedbackPageParam.getUserId());
        }
        if(ObjectUtil.isNotEmpty(feedbackPageParam.getFeedbackText())) {
            queryWrapper.lambda().like(Feedback::getFeedbackText, feedbackPageParam.getFeedbackText());
        }
        if(ObjectUtil.isNotEmpty(feedbackPageParam.getPriority())) {
            queryWrapper.lambda().eq(Feedback::getPriority, feedbackPageParam.getPriority());
        }
        if(ObjectUtil.isNotEmpty(feedbackPageParam.getStatus())) {
            queryWrapper.lambda().eq(Feedback::getStatus, feedbackPageParam.getStatus());
        }
        if(ObjectUtil.isAllNotEmpty(feedbackPageParam.getSortField(), feedbackPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(feedbackPageParam.getSortOrder());
            queryWrapper.orderBy(true, feedbackPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()),
                    StrUtil.toUnderlineCase(feedbackPageParam.getSortField()));
        } else {
            queryWrapper.lambda().orderByAsc(Feedback::getId);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(FeedbackAddParam feedbackAddParam) {
        Feedback feedback = BeanUtil.toBean(feedbackAddParam, Feedback.class);
        this.save(feedback);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(FeedbackEditParam feedbackEditParam) {
        Feedback feedback = this.queryEntity(feedbackEditParam.getId());
        BeanUtil.copyProperties(feedbackEditParam, feedback);
        this.updateById(feedback);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<FeedbackIdParam> feedbackIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(feedbackIdParamList, FeedbackIdParam::getId));
    }

    @Override
    public Feedback detail(FeedbackIdParam feedbackIdParam) {
        return this.queryEntity(feedbackIdParam.getId());
    }

    @Override
    public Feedback queryEntity(String id) {
        Feedback feedback = this.getById(id);
        if(ObjectUtil.isEmpty(feedback)) {
            throw new CommonException("Feedback不存在，id值为：{}", id);
        }
        return feedback;
    }
}
