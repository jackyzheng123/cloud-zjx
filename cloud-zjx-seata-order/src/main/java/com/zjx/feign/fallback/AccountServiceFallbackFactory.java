package com.zjx.feign.fallback;

import com.zjx.dto.AccountDTO;
import com.zjx.feign.AccountServiceClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/25 11:19
 * @Version V1.0
 **/
@Component
@Slf4j
public class AccountServiceFallbackFactory implements FallbackFactory<AccountServiceClient> {

    @Override
    public AccountServiceClient create(Throwable throwable) {
        return new AccountServiceClient() {
            @Override
            public void debit(String userId, BigDecimal orderMoney) {
                log.error("扣款失败，", throwable);
            }

        };
    }

}
