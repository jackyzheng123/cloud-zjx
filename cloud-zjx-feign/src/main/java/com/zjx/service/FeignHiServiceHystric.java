package com.zjx.service;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2019/4/10 10:56
 * @Version V1.0
 **/

@Component
public class FeignHiServiceHystric implements FeignHiService {

    @Override
    public String say() {
        return "sorry request error";
    }
}
