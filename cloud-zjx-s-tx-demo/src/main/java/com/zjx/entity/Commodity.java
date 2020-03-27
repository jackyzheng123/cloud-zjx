package com.zjx.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 商品
 * @Author Carson Cheng
 * @Date 2020/3/24 11:27
 * @Version V1.0
 **/
@Data
public class Commodity {

    private Long id;
    private String commodityCode;
    private String commodityName;
    private BigDecimal price;
}
