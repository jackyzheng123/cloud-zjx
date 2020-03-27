package com.zjx.service;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:19
 * @Version V1.0
 **/
public interface BusinessService {

    /**
     * purchase
     */
    void purchase(String userId, String commodityCode, Integer count);

}
