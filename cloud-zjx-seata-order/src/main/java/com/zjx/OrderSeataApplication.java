package com.zjx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.zjx.mapper")
@EnableTransactionManagement
@EnableFeignClients
public class OrderSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSeataApplication.class, args);
    }

}
