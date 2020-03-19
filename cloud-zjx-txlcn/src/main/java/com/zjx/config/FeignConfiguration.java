package com.zjx.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 10:56
 * @Version V1.0
 **/
@ComponentScan
@Configuration
@EnableFeignClients
public class FeignConfiguration {

}
