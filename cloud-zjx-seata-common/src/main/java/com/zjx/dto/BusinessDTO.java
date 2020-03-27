package com.zjx.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 17:21
 * @Version V1.0
 **/
@Data
public class BusinessDTO implements Serializable {

    private String userId;

    private String commodityCode;

    private Integer count;

}
