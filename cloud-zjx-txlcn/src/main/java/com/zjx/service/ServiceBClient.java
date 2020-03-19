package com.zjx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 10:57
 * @Version V1.0
 **/
@FeignClient(value = "cloud-zjx-txlcn-serviceB", fallback = ServiceBFallback.class)
public interface ServiceBClient {

    @GetMapping("/rpc")
    String rpc(@RequestParam("value") String name);
}