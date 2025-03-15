
package me.zhangyifeng.biz.modular.rentalOption.service.impl;

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
import me.zhangyifeng.biz.modular.rentalOption.entity.RentalOption;
import me.zhangyifeng.biz.modular.rentalOption.mapper.RentalOptionMapper;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionAddParam;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionEditParam;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionIdParam;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionPageParam;
import me.zhangyifeng.biz.modular.rentalOption.service.RentalOptionService;

import java.util.List;

/**
 * RentalOptionService接口实现类
 *
 * @author 张一风
 * @date  2025/03/07 22:56
 **/
@Service
public class RentalOptionServiceImpl extends ServiceImpl<RentalOptionMapper, RentalOption> implements RentalOptionService {

    @Override
    public Page<RentalOption> page(RentalOptionPageParam rentalOptionPageParam) {
        QueryWrapper<RentalOption> queryWrapper = new QueryWrapper<RentalOption>().checkSqlInjection();
        if(ObjectUtil.isNotEmpty(rentalOptionPageParam.getOptionName())) {
            queryWrapper.lambda().like(RentalOption::getOptionName, rentalOptionPageParam.getOptionName());
        }
        if(ObjectUtil.isNotEmpty(rentalOptionPageParam.getDurationHours())) {
            queryWrapper.lambda().eq(RentalOption::getDurationHours, rentalOptionPageParam.getDurationHours());
        }
        if(ObjectUtil.isNotEmpty(rentalOptionPageParam.getDescription())) {
            queryWrapper.lambda().like(RentalOption::getDescription, rentalOptionPageParam.getDescription());
        }
        if(ObjectUtil.isNotEmpty(rentalOptionPageParam.getStartCreateTime()) && ObjectUtil.isNotEmpty(rentalOptionPageParam.getEndCreateTime())) {
            queryWrapper.lambda().between(RentalOption::getCreateTime, rentalOptionPageParam.getStartCreateTime(), rentalOptionPageParam.getEndCreateTime());
        }
        if(ObjectUtil.isNotEmpty(rentalOptionPageParam.getStartUpdateTime()) && ObjectUtil.isNotEmpty(rentalOptionPageParam.getEndUpdateTime())) {
            queryWrapper.lambda().between(RentalOption::getUpdateTime, rentalOptionPageParam.getStartUpdateTime(), rentalOptionPageParam.getEndUpdateTime());
        }
        if(ObjectUtil.isAllNotEmpty(rentalOptionPageParam.getSortField(), rentalOptionPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(rentalOptionPageParam.getSortOrder());
            queryWrapper.orderBy(true, rentalOptionPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()),
                    StrUtil.toUnderlineCase(rentalOptionPageParam.getSortField()));
        } else {
            queryWrapper.lambda().orderByAsc(RentalOption::getId);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(RentalOptionAddParam rentalOptionAddParam) {
        RentalOption rentalOption = BeanUtil.toBean(rentalOptionAddParam, RentalOption.class);
        this.save(rentalOption);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(RentalOptionEditParam rentalOptionEditParam) {
        RentalOption rentalOption = this.queryEntity(rentalOptionEditParam.getId());
        BeanUtil.copyProperties(rentalOptionEditParam, rentalOption);
        this.updateById(rentalOption);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<RentalOptionIdParam> rentalOptionIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(rentalOptionIdParamList, RentalOptionIdParam::getId));
    }

    @Override
    public RentalOption detail(RentalOptionIdParam rentalOptionIdParam) {
        return this.queryEntity(rentalOptionIdParam.getId());
    }

    @Override
    public RentalOption queryEntity(String id) {
        RentalOption rentalOption = this.getById(id);
        if(ObjectUtil.isEmpty(rentalOption)) {
            throw new CommonException("RentalOption不存在，id值为：{}", id);
        }
        return rentalOption;
    }
}
