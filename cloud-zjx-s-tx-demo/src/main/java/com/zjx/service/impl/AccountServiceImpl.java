package com.zjx.service.impl;

import com.zjx.mapper.AccountMapper;
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
    public void debit(String userId, BigDecimal money) {
        accountMapper.debit(userId, money);
    }
}
