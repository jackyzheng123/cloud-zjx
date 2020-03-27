package com.zjx.service;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:10
 * @Version V1.0
 **/
public interface OrderService {

    /**
     * 创建订单
     */
    boolean create(String userId, String commodityCode, int orderCount);

}
