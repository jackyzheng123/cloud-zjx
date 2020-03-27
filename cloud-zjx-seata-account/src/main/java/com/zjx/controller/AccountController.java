package com.zjx.controller;

import com.zjx.dto.AccountDTO;
import com.zjx.service.AccountService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 12:04
 * @Version V1.0
 **/
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping("/debit")
    public void debit(@RequestParam("userId") String userId, @RequestParam("orderMoney") BigDecimal orderMoney) {
        accountService.debit(userId, orderMoney);
    }
}
