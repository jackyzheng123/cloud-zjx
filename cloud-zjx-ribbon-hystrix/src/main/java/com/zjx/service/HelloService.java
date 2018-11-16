package com.zjx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "error")
	public String sayHello() {
		return restTemplate.getForObject("http://cloud-zjx-provider/hi", String.class);
	}
	
	public String error(){
		return "sorry, error";
	}

}
