package com.zjx.mapper;

import com.zjx.dto.CommodityDTO;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 12:16
 * @Version V1.0
 **/
public interface CommodityMapper {

    CommodityDTO findCommodity(String commodityCode);
}
