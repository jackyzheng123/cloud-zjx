package com.zjx.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description 订单
 * @Author Carson Cheng
 * @Date 2020/3/24 11:12
 * @Version V1.0
 **/
@Data
public class OrderDTO implements Serializable {

    private String userId;

    private String orderNo;
    
    private String commodityCode;

    private Integer count;

    private BigDecimal money;

    private Date createDate;

}
