package com.zjx.service.impl;

import com.zjx.feign.OrderServiceClient;
import com.zjx.feign.StorageServiceClient;
import com.zjx.service.BusinessService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:19
 * @Version V1.0
 **/
@Service
public class BusinessServiceImpl implements BusinessService {

    private final StorageServiceClient storageServiceClient;

    private final OrderServiceClient orderServiceClient;

    public BusinessServiceImpl(StorageServiceClient storageServiceClient, OrderServiceClient orderServiceClient) {
        this.storageServiceClient = storageServiceClient;
        this.orderServiceClient = orderServiceClient;
    }

    @Override
    @GlobalTransactional
    public void purchase(String userId, String commodityCode, Integer count) {
        // 减库存
        storageServiceClient.deduct(commodityCode, count);

        // 创建订单
        orderServiceClient.create(userId, commodityCode, count);
    }
}
