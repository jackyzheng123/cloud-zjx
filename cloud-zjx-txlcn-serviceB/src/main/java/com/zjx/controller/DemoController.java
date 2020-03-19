package com.zjx.controller;

import com.zjx.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 14:12
 * @Version V1.0
 **/
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/rpc")
    public String rpc(@RequestParam("value") String value, HttpServletRequest servletRequest) {
        return demoService.rpc(value);
    }

}