package com.zjx.mapper;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:54
 * @Version V1.0
 **/
public interface AccountMapper {

    /**
     * 扣钱
     *
     * @param userId
     * @param money
     */
    void debit(String userId, BigDecimal money);

    /**
     * 查余额
     *
     * @param userId
     * @return
     */
    BigDecimal queryMoney(String userId);
}
