package com.zjx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zjx.service.FeignHiService;

@RestController
public class HelloController {

	@Autowired
	private FeignHiService feignHiService;
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String hi(){
		return feignHiService.say();
	}
}
