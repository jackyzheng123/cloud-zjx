package com.zjx.myhystrix;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Description 自定义熔断实现
 * @Author Carson Cheng
 * @Date 2020/3/12 16:24
 * @Version V1.0
 **/
@RestController
public class MyHystrixController {

    private Random random = new Random();

    @MyHystrixCommand(fallback = "errorMethod")
    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String message) throws InterruptedException {
        int time = random.nextInt(200);
        System.out.println("spend time : " + time + "ms");
        // 模拟请求超时
        Thread.sleep(time);
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhh");
        return "hello world:" + message;
    }

    /**
     * fallback方法
     * @param message
     * @return
     */
    public String errorMethod(String message) {
        return "error message";
    }


}
