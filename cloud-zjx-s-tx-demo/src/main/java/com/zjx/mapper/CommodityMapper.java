package com.zjx.mapper;

import com.zjx.entity.Commodity;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 12:16
 * @Version V1.0
 **/
public interface CommodityMapper {

    Commodity findCommodity(String commodityCode);
}
