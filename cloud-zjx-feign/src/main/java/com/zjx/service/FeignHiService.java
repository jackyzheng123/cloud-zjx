package com.zjx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("cloud-zjx-provider")
public interface FeignHiService {

	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String say();
}
