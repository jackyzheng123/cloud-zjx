package com.zjx.service;

import com.zjx.dto.CommodityDTO;
import com.zjx.entity.Commodity;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:33
 * @Version V1.0
 **/
public interface CommodityService {

    /**
     *
     * @param commodityCode
     * @return
     */
    CommodityDTO findCommodity (String commodityCode);
}
