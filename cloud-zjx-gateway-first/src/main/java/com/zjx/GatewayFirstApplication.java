package com.zjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class GatewayFirstApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(GatewayFirstApplication.class, args);
    }

    @Bean
    public RouteLocatorBuilder routeLocatorBuilder() {
        return new RouteLocatorBuilder(context);
    }

    /**
     * 使用了一个RouteLocatorBuilder的bean去创建路由，除了创建路由RouteLocatorBuilder可以让你添加各种predicates和filters，
     * predicates断言的意思，顾名思义就是根据具体的请求的规则，由具体的route去处理，
     * filters是各种过滤器，用来对请求做各种判断和修改。
     * <p>
     * 创建的route可以让请求“/get”请求都转发到“http://httpbin.org/get”。
     * 在route配置上，我们添加了一个filter，该filter会将请求添加一个header,key为Hello，value为World。
     * <p>
     * 访问http://localhost:8080/get
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(p -> p.host("*.hystrix.com") // 使用host去断言请求是否进入该路由
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }

    /**
     * Mono是一个Reactive stream，对外输出一个“fallback”字符串。
     */
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

}
