package com.zjx.service.impl;

import com.zjx.dto.CommodityDTO;
import com.zjx.dto.OrderDTO;
import com.zjx.feign.AccountServiceClient;
import com.zjx.feign.CommodityServiceClient;
import com.zjx.feign.StorageServiceClient;
import com.zjx.mapper.OrderMapper;
import com.zjx.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:21
 * @Version V1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final StorageServiceClient storageServiceClient;

    private final AccountServiceClient accountServiceClient;

    private final CommodityServiceClient commodityServiceClient;

    public OrderServiceImpl(OrderMapper orderMapper, StorageServiceClient storageServiceClient, AccountServiceClient accountServiceClient, CommodityServiceClient commodityServiceClient) {
        this.orderMapper = orderMapper;
        this.storageServiceClient = storageServiceClient;
        this.accountServiceClient = accountServiceClient;
        this.commodityServiceClient = commodityServiceClient;
    }

    @Override
    @GlobalTransactional
    public boolean purchase(String userId, String commodityCode, Integer count) {
        // 减库存
        storageServiceClient.deduct(commodityCode, count);

        // 计算订单金额
        final BigDecimal orderMoney = calculate(commodityCode, count);
        // 支付
        accountServiceClient.debit(userId, orderMoney);

        // 保存订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(userId);
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
        orderDTO.setCommodityCode(commodityCode);
        orderDTO.setCount(count);
        orderDTO.setMoney(orderMoney);

        // int i = 1/0; // TODO 模拟异常
        return orderMapper.insert(orderDTO);
    }

    /**
     * 计算订单金额
     *
     * @param commodityCode
     * @param orderCount
     * @return
     */
    private BigDecimal calculate(String commodityCode, int orderCount) {
        final CommodityDTO commodity = commodityServiceClient.findCommodity(commodityCode);
        final BigDecimal price = commodity.getPrice();
        return price.multiply(new BigDecimal(orderCount));
    }
}
