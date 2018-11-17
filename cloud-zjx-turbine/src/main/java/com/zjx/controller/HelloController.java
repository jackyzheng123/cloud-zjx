package com.zjx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/hello")
	@HystrixCommand(fallbackMethod = "hiError")
	public String hello() {
		return "Hi Hystrix DashBoard, form port:" + port;
	}

	public String hiError() {
		return "Sorry,error!";
	}

}
