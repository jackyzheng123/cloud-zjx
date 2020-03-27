package com.zjx.controller;

import com.zjx.service.BusinessService;
import org.springframework.web.bind.annotation.PutMapping;
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
     * @param userId 用户id
     * @param commodityCode 商品编码
     * @param orderCount 商品数量
     */
    @PutMapping("/purchase")
    public void purchase(@RequestParam String userId, @RequestParam String commodityCode, @RequestParam int orderCount) {
        businessService.purchase(userId, commodityCode, orderCount);
    }
}
