package com.zjx.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 订单表
 * @Author Carson Cheng
 * @Date 2020/3/24 11:12
 * @Version V1.0
 **/
@Data
public class Order {
    
    private Long id;
    private String userId;
    private String commodityCode;
    private Integer count;
    private BigDecimal money;

}
