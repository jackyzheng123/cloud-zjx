package com.zjx.mapper;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:50
 * @Version V1.0
 **/
public interface StorageMapper {

    /**
     * 减库存
     *
     * @param commodityCode
     * @param count
     */
    void deduct(String commodityCode, int count);

    /**
     * 查库存
     *
     * @param commodityCode
     * @return
     */
    Integer queryStorage(String commodityCode);
}
