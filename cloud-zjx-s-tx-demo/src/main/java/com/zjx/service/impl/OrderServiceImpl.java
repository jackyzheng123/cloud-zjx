package com.zjx.service.impl;

import com.zjx.mapper.OrderMapper;
import com.zjx.entity.Commodity;
import com.zjx.entity.Order;
import com.zjx.service.AccountService;
import com.zjx.service.CommodityService;
import com.zjx.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:21
 * @Version V1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final AccountService accountService;

    private final CommodityService commodityService;

    public OrderServiceImpl(OrderMapper orderMapper, AccountService accountService, CommodityService commodityService) {
        this.orderMapper = orderMapper;
        this.accountService = accountService;
        this.commodityService = commodityService;
    }

    @Override
    public boolean create(String userId, String commodityCode, int orderCount) {

        // 计算订单金额
        final BigDecimal orderMoney = calculate(commodityCode, orderCount);
        // 支付
        accountService.debit(userId, orderMoney);

        //int i = 1/0;

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);

        // 保存订单
        return orderMapper.insert(order);
    }

    /**
     * 计算订单金额
     * @param commodityCode
     * @param orderCount
     * @return
     */
    private BigDecimal calculate(String commodityCode, int orderCount) {
        final Commodity commodity = commodityService.findCommodity(commodityCode);
        final BigDecimal price = commodity.getPrice();
        return price.multiply(new BigDecimal(orderCount));
    }
}
