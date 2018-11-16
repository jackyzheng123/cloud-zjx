package com.zjx.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

	@RequestMapping("/hi")
	//public String say(@RequestParam("name") String name){
	public String say(){
		System.out.println("hahah");
		return "hello world";
	}
}
