package com.zjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 如何利用Hystrix Dashboard去监控断路器的Hystrix command
 * 
 *在请求http://localhost:8762/actuator/hystrix.stream之前，加配置，并需要随便请求一个接口，例如：http://localhost:8762/hi，否则会一直ping ping ping
 *
 *打开http://localhost:8762/hystrix可以看见图形界面
 *
 * @author jacky
 * @date 2018年11月18日
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
	
}
