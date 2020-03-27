package com.zjx.service.impl;

import com.zjx.service.BusinessService;
import com.zjx.service.OrderService;
import com.zjx.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:19
 * @Version V1.0
 **/
@Service
public class BusinessServiceImpl implements BusinessService {

    private final StorageService storageService;

    private final OrderService orderService;

    public BusinessServiceImpl(StorageService storageService, OrderService orderService) {
        this.storageService = storageService;
        this.orderService = orderService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void purchase(String userId, String commodityCode, int orderCount) {
        // 减库存
        storageService.deduct(commodityCode, orderCount);

        //int i = 1/0;

        // 创建订单
        orderService.create(userId, commodityCode, orderCount);
    }
}
