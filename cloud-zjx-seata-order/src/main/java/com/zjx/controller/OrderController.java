package com.zjx.controller;

import com.zjx.dto.OrderDTO;
import com.zjx.service.OrderService;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 12:04
 * @Version V1.0
 **/
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 下单
     */
    @GetMapping("/purchase")
    public boolean purchase(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count) {
        return orderService.purchase(userId, commodityCode, count);
    }
}
