package com.zjx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zjx.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String say(){
		return helloService.sayHello();
	}
}
