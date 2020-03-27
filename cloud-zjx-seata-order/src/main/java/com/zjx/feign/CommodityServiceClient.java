package com.zjx.feign;

import com.zjx.dto.AccountDTO;
import com.zjx.dto.CommodityDTO;
import com.zjx.feign.fallback.AccountServiceFallbackFactory;
import com.zjx.feign.fallback.CommodityServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:10
 * @Version V1.0
 **/
@FeignClient(value = "cloud-zjx-seata-commodity", fallbackFactory = CommodityServiceFallbackFactory.class)
public interface CommodityServiceClient {

    @GetMapping("/findCommodity")
    CommodityDTO findCommodity(@RequestParam String commodityCode);

}
