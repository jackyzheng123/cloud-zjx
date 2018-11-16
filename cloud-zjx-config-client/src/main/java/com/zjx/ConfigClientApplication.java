package com.zjx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
 * @author zhengjiaxing
 * @date 2018年11月16日
 */
@SpringBootApplication
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
