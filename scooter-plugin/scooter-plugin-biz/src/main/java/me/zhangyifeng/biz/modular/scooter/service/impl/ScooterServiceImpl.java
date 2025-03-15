
package me.zhangyifeng.biz.modular.scooter.service.impl;

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
import me.zhangyifeng.biz.modular.scooter.entity.Scooter;
import me.zhangyifeng.biz.modular.scooter.mapper.ScooterMapper;
import me.zhangyifeng.biz.modular.scooter.param.ScooterAddParam;
import me.zhangyifeng.biz.modular.scooter.param.ScooterEditParam;
import me.zhangyifeng.biz.modular.scooter.param.ScooterIdParam;
import me.zhangyifeng.biz.modular.scooter.param.ScooterPageParam;
import me.zhangyifeng.biz.modular.scooter.service.ScooterService;

import java.util.List;

/**
 * ScooterService接口实现类
 *
 * @author 张一风
 * @date  2025/03/07 22:51
 **/
@Service
public class ScooterServiceImpl extends ServiceImpl<ScooterMapper, Scooter> implements ScooterService {

    @Override
    public Page<Scooter> page(ScooterPageParam scooterPageParam) {
        QueryWrapper<Scooter> queryWrapper = new QueryWrapper<Scooter>().checkSqlInjection();
        if(ObjectUtil.isNotEmpty(scooterPageParam.getModel())) {
            queryWrapper.lambda().eq(Scooter::getModel, scooterPageParam.getModel());
        }
        if(ObjectUtil.isNotEmpty(scooterPageParam.getStatus())) {
            queryWrapper.lambda().eq(Scooter::getStatus, scooterPageParam.getStatus());
        }
        if(ObjectUtil.isNotEmpty(scooterPageParam.getBatteryLevel())) {
            queryWrapper.lambda().eq(Scooter::getBatteryLevel, scooterPageParam.getBatteryLevel());
        }
        if(ObjectUtil.isNotEmpty(scooterPageParam.getStartLastMaintenanceDate()) && ObjectUtil.isNotEmpty(scooterPageParam.getEndLastMaintenanceDate())) {
            queryWrapper.lambda().between(Scooter::getLastMaintenanceDate, scooterPageParam.getStartLastMaintenanceDate(), scooterPageParam.getEndLastMaintenanceDate());
        }
        if(ObjectUtil.isAllNotEmpty(scooterPageParam.getSortField(), scooterPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(scooterPageParam.getSortOrder());
            queryWrapper.orderBy(true, scooterPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()),
                    StrUtil.toUnderlineCase(scooterPageParam.getSortField()));
        } else {
            queryWrapper.lambda().orderByAsc(Scooter::getId);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(ScooterAddParam scooterAddParam) {
        Scooter scooter = BeanUtil.toBean(scooterAddParam, Scooter.class);
        this.save(scooter);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(ScooterEditParam scooterEditParam) {
        Scooter scooter = this.queryEntity(scooterEditParam.getId());
        BeanUtil.copyProperties(scooterEditParam, scooter);
        this.updateById(scooter);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<ScooterIdParam> scooterIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(scooterIdParamList, ScooterIdParam::getId));
    }

    @Override
    public Scooter detail(ScooterIdParam scooterIdParam) {
        return this.queryEntity(scooterIdParam.getId());
    }

    @Override
    public Scooter queryEntity(String id) {
        Scooter scooter = this.getById(id);
        if(ObjectUtil.isEmpty(scooter)) {
            throw new CommonException("Scooter不存在，id值为：{}", id);
        }
        return scooter;
    }
}
