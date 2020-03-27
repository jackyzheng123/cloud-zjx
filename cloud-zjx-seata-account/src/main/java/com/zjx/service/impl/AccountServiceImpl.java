package com.zjx.service.impl;

import com.zjx.mapper.AccountMapper;
import com.zjx.dto.AccountDTO;
import com.zjx.service.AccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:51
 * @Version V1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public void debit(String userId, BigDecimal orderMoney) {
        // 查余额
        BigDecimal money = accountMapper.queryMoney(userId);
        if (money.compareTo(orderMoney) < 0) {
            try {
                throw new Exception("余额不足");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 扣钱
            accountMapper.debit(userId, orderMoney);
        }
    }
}
