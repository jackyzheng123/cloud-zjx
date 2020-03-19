package com.zjx.service;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 10:58
 * @Version V1.0
 **/
@Component
public class ServiceBFallback implements ServiceBClient {

    @Override
    public String rpc(String name) {
        return "service-b fallback";
    }
}