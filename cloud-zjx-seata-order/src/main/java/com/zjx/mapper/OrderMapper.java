package com.zjx.mapper;

import com.zjx.dto.OrderDTO;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:23
 * @Version V1.0
 **/
public interface OrderMapper {

    boolean insert(OrderDTO orderDTO);
}
