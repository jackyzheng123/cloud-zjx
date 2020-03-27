package com.zjx.service;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:09
 * @Version V1.0
 **/
public interface StorageService {

    /**
     * 减库存
     */
    void deduct(String commodityCode, int count);

}
