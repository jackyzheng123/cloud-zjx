package com.zjx.feign;

import com.zjx.feign.fallback.OrderServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:10
 * @Version V1.0
 **/
@FeignClient(name = "cloud-zjx-seata-order", fallbackFactory = OrderServiceFallbackFactory.class)
public interface OrderServiceClient {

    /**
     * 创建订单
     */
    @PostMapping("/add")
    boolean create(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);

}
