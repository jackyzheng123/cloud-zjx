package com.zjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

/**
 * 常见的限流算法
 * 计数器算法
 * 漏桶算法 : 可以准备一个队列，用来保存请求，另外通过一个线程池（ScheduledExecutorService）来定期从队列中获取请求并执行，可以一次性获取多个并发执行。
 * 令牌桶算法: 实现思路：可以准备一个队列，用来保存令牌，另外通过一个线程池定期生成令牌放到队列中，每来一个请求，就从队列中获取一个令牌，并继续执行。
 * <p>
 * Spring Cloud Gateway官方就提供了RequestRateLimiterGatewayFilterFactory这个类，适用Redis和lua脚本实现了令牌桶的方式
 * RequestRateLimiter是使用Redis来进行限流的，并在redis中存储了2个key.关注这两个key含义可以看lua源代码。
 */
@SpringBootApplication
public class GatewayRateLimitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayRateLimitApplication.class, args);
    }

    /**
     * 根据Hostname进行限流，则需要用hostAddress去判断
     */
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

    /**
     * 根据uri去限流
     */
    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    /**
     * 用户的维度去限流
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }
}
