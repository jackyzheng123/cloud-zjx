package com.zjx.service;

import com.zjx.dto.AccountDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:10
 * @Version V1.0
 **/
public interface AccountService {

    /**
     * debit balance of user's account
     */
    void debit(String userId, BigDecimal orderMoney);

}
