package com.zjx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * github上的配置文件的名字构成必须是: {application}-{profile}.properties
 * 
 * http请求地址和资源文件映射如下:
 * 
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * 
 * 启动程序：访问http://localhost:8768/name/dev
 * 
 * 
 * 	post请求向端口为8770的config-client发送请求/bus/refresh／
 * 发送post请求：http://localhost:8770/actuator/bus-refresh
 * 确保rabbitmq服务开启
 *
 * 另外，/actuator/bus-refresh接口可以指定服务，即使用"destination"参数，比如 “/actuator/bus-refresh?destination=customers:**” 即刷新服务名为customers的所有服务。
 * 
 * @author zhengjiaxing
 * @date 2018年11月16日
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
@RestController
public class ConfigClientApplication {

	@Value("${name}")
	private String name;
	@Value("${age}")
	private String age;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@RequestMapping("/hi")
	public String hi(){
		return "hi, I'm " + name + ", " + age + " years old, Nice to meet you";
	}
	
}
