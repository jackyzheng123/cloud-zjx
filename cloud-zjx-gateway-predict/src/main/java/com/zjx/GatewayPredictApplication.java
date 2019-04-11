package com.zjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 网关作为一个系统的流量的入口，有着举足轻重的作用，通常的作用如下:
 * <p>
 * 1.协议转换，路由转发
 * 2.流量聚合，对流量进行监控，日志输出
 * 3.作为整个系统的前端工程，对流量进行控制，有限流的作用
 * 4.作为系统的前端边界，外部流量只能通过网关才能访问系统
 * 5.可以在网关层做权限的判断
 * 6.可以在网关层做缓存
 * <p>
 * <p>
 * 请求和路由进行匹配，这时候就需要用到predicate，它是决定了一个请求走哪一个路由
 * Predict作为断言，它决定了请求会被路由到哪个router 中。在断言之后，请求会被进入到filter过滤器的逻辑
 */
@SpringBootApplication
public class GatewayPredictApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayPredictApplication.class, args);
    }

}
