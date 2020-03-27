package com.zjx.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 库存
 * @Author Carson Cheng
 * @Date 2020/3/24 11:15
 * @Version V1.0
 **/
@Data
public class StorageDTO implements Serializable {

    private String commodityCode;

    private Integer count;

}
