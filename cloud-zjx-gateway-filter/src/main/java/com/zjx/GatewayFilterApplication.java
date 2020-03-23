package com.zjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Predict决定了请求由哪一个路由处理，在路由处理之前，需要经过“pre”类型的过滤器处理，处理返回响应之后，可以由“post”类型的过滤器处理
 * <p>
 * 在"pre”类型的过滤器可以做参数校验、权限校验、流量监控、日志输出、协议转换等，
 * 在“post”类型的过滤器中可以做响应内容、响应头的修改，日志的输出，流量监控等
 * <p>
 * <p>
 * 当我们有很多个服务时，比如user-service、goods-service、sales-service等服务
 * 客户端请求各个服务的Api时，每个服务都需要做相同的事情，比如鉴权、限流、日志输出等
 * 在微服务的上一层加一个全局的权限控制、限流、日志输出的Api Gateway服务
 * <p>
 * Spring Cloud Gateway同zuul类似，有“pre”和“post”两种方式的filter
 * <p>
 * *
 */
@SpringBootApplication
public class GatewayFilterApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(GatewayFilterApplication.class, args);
    }

//    @Bean
//    public RouteLocatorBuilder routeLocatorBuilder() {
//        return new RouteLocatorBuilder(context);
//    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/customer/**")
                        .filters(f -> f
                                .filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
    }

}
