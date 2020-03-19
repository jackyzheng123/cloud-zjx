package com.zjx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 10:58
 * @Version V1.0
 **/
@FeignClient(value = "cloud-zjx-txlcn-serviceC", fallback = ServiceCFallback.class)
public interface ServiceCClient {

    @GetMapping("/rpc")
    String rpc(@RequestParam("value") String name);
}
