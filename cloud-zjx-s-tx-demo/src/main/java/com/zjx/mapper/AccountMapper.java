package com.zjx.mapper;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:54
 * @Version V1.0
 **/
public interface AccountMapper {

    void debit(String userId, BigDecimal money);
}
