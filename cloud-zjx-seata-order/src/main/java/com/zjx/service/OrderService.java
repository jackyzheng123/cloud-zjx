package com.zjx.service;

import com.zjx.dto.OrderDTO;
import org.springframework.web.bind.annotation.RequestParam;

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
    boolean purchase(String userId, String commodityCode, Integer count);

}
