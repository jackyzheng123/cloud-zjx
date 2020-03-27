package com.zjx.entity;

import lombok.Data;

/**
 * @Description 库存表
 * @Author Carson Cheng
 * @Date 2020/3/24 11:15
 * @Version V1.0
 **/
@Data
public class Storage {

    private Long id;
    private String commodityCode;
    private Integer count;

}
