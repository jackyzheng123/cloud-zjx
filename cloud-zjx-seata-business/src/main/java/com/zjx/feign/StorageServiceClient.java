package com.zjx.feign;

import com.zjx.feign.fallback.StorageServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:09
 * @Version V1.0
 **/
@FeignClient(name = "cloud-zjx-seata-storage", fallbackFactory = StorageServiceFallbackFactory.class)
public interface StorageServiceClient {

    /**
     * 减库存
     */
    @PutMapping("/deduct")
    void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);

}
