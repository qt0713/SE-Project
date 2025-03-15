
package me.zhangyifeng.biz.modular.userDiscount.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.zhangyifeng.biz.modular.userDiscount.entity.UserDiscount;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountAddParam;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountEditParam;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountIdParam;
import me.zhangyifeng.biz.modular.userDiscount.param.UserDiscountPageParam;

import java.util.List;

/**
 * UserDiscountService接口
 *
 * @author 张一风
 * @date  2025/03/07 23:09
 **/
public interface UserDiscountService extends IService<UserDiscount> {

    /**
     * 获取UserDiscount分页
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    Page<UserDiscount> page(UserDiscountPageParam userDiscountPageParam);

    /**
     * 添加UserDiscount
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    void add(UserDiscountAddParam userDiscountAddParam);

    /**
     * 编辑UserDiscount
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    void edit(UserDiscountEditParam userDiscountEditParam);

    /**
     * 删除UserDiscount
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    void delete(List<UserDiscountIdParam> userDiscountIdParamList);

    /**
     * 获取UserDiscount详情
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     */
    UserDiscount detail(UserDiscountIdParam userDiscountIdParam);

    /**
     * 获取UserDiscount详情
     *
     * @author 张一风
     * @date  2025/03/07 23:09
     **/
    UserDiscount queryEntity(String id);
}
