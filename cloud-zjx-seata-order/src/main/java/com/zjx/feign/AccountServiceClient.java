package com.zjx.feign;

import com.zjx.dto.AccountDTO;
import com.zjx.feign.fallback.AccountServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:10
 * @Version V1.0
 **/
@FeignClient(name = "cloud-zjx-seata-account", fallbackFactory = AccountServiceFallbackFactory.class)
public interface AccountServiceClient {

    /**
     * debit balance of user's account
     */
    @PutMapping("/debit")
    void debit(@RequestParam("userId") String userId, @RequestParam("orderMoney") BigDecimal orderMoney);

}
