
package me.zhangyifeng.biz.modular.scooter.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.zhangyifeng.biz.modular.scooter.entity.Scooter;
import me.zhangyifeng.biz.modular.scooter.param.ScooterAddParam;
import me.zhangyifeng.biz.modular.scooter.param.ScooterEditParam;
import me.zhangyifeng.biz.modular.scooter.param.ScooterIdParam;
import me.zhangyifeng.biz.modular.scooter.param.ScooterPageParam;

import java.util.List;

/**
 * ScooterService接口
 *
 * @author 张一风
 * @date  2025/03/07 22:51
 **/
public interface ScooterService extends IService<Scooter> {

    /**
     * 获取Scooter分页
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    Page<Scooter> page(ScooterPageParam scooterPageParam);

    /**
     * 添加Scooter
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    void add(ScooterAddParam scooterAddParam);

    /**
     * 编辑Scooter
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    void edit(ScooterEditParam scooterEditParam);

    /**
     * 删除Scooter
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    void delete(List<ScooterIdParam> scooterIdParamList);

    /**
     * 获取Scooter详情
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     */
    Scooter detail(ScooterIdParam scooterIdParam);

    /**
     * 获取Scooter详情
     *
     * @author 张一风
     * @date  2025/03/07 22:51
     **/
    Scooter queryEntity(String id);
}
