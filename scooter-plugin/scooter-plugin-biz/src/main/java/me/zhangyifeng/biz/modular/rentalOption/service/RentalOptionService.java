
package me.zhangyifeng.biz.modular.rentalOption.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.zhangyifeng.biz.modular.rentalOption.entity.RentalOption;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionAddParam;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionEditParam;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionIdParam;
import me.zhangyifeng.biz.modular.rentalOption.param.RentalOptionPageParam;

import java.util.List;

/**
 * RentalOptionService接口
 *
 * @author 张一风
 * @date  2025/03/07 22:56
 **/
public interface RentalOptionService extends IService<RentalOption> {

    /**
     * 获取RentalOption分页
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    Page<RentalOption> page(RentalOptionPageParam rentalOptionPageParam);

    /**
     * 添加RentalOption
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    void add(RentalOptionAddParam rentalOptionAddParam);

    /**
     * 编辑RentalOption
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    void edit(RentalOptionEditParam rentalOptionEditParam);

    /**
     * 删除RentalOption
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    void delete(List<RentalOptionIdParam> rentalOptionIdParamList);

    /**
     * 获取RentalOption详情
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     */
    RentalOption detail(RentalOptionIdParam rentalOptionIdParam);

    /**
     * 获取RentalOption详情
     *
     * @author 张一风
     * @date  2025/03/07 22:56
     **/
    RentalOption queryEntity(String id);
}
