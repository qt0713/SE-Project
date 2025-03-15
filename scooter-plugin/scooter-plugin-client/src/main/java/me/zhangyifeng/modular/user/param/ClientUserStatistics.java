package me.zhangyifeng.modular.user.param;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author: zhangyifeng
 * @description :
 * @date: 2025/3/10 13:49
 * @version: 1.0
 */

@Getter
@Setter
public class ClientUserStatistics {
    private BigDecimal amount;
    private Long records;
    private Long feedbacks;
}
