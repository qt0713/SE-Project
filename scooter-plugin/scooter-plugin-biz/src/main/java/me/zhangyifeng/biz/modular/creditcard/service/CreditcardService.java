
package me.zhangyifeng.biz.modular.creditcard.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.zhangyifeng.biz.modular.creditcard.entity.Creditcard;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardAddParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardEditParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardIdParam;
import me.zhangyifeng.biz.modular.creditcard.param.CreditcardPageParam;

import java.util.List;

/**
 * CreditCardService接口
 *
 * @author 张一风
 * @date  2025/03/09 11:38
 **/
public interface CreditcardService extends IService<Creditcard> {

    /**
     * 获取CreditCard分页
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    Page<Creditcard> page(CreditcardPageParam creditcardPageParam);

    /**
     * 添加CreditCard
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    void add(CreditcardAddParam creditcardAddParam);

    /**
     * 编辑CreditCard
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    void edit(CreditcardEditParam creditcardEditParam);

    /**
     * 删除CreditCard
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    void delete(List<CreditcardIdParam> creditcardIdParamList);

    /**
     * 获取CreditCard详情
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     */
    Creditcard detail(CreditcardIdParam creditcardIdParam);

    /**
     * 获取CreditCard详情
     *
     * @author 张一风
     * @date  2025/03/09 11:38
     **/
    Creditcard queryEntity(String id);
}
