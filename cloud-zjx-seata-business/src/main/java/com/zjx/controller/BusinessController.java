package com.zjx.controller;

import com.zjx.response.ObjectResponse;
import com.zjx.service.BusinessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 12:04
 * @Version V1.0
 **/
@RestController
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    /**
     * 下单
     */
    @PostMapping("/purchase")
    public ObjectResponse<String> purchase(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count) {
        businessService.purchase(userId, commodityCode, count);
        return new ObjectResponse<>();
    }
}
