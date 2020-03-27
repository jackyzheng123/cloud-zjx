package com.zjx.service.impl;

import com.zjx.mapper.OrderMapper;
import com.zjx.dto.AccountDTO;
import com.zjx.dto.CommodityDTO;
import com.zjx.dto.OrderDTO;
import com.zjx.feign.AccountServiceClient;
import com.zjx.feign.CommodityServiceClient;
import com.zjx.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
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

    private final AccountServiceClient accountServiceClient;

    private final CommodityServiceClient commodityServiceClient;

    public OrderServiceImpl(OrderMapper orderMapper, AccountServiceClient accountServiceClient, CommodityServiceClient commodityServiceClient) {
        this.orderMapper = orderMapper;
        this.accountServiceClient = accountServiceClient;
        this.commodityServiceClient = commodityServiceClient;
    }

    @Override
    public boolean create(String userId, String commodityCode, Integer count) {
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
