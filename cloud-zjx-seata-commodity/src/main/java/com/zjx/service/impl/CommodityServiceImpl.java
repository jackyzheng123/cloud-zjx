package com.zjx.service.impl;

import com.zjx.mapper.CommodityMapper;
import com.zjx.dto.CommodityDTO;
import com.zjx.service.CommodityService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 12:15
 * @Version V1.0
 **/
@Service
public class CommodityServiceImpl implements CommodityService {

    private final CommodityMapper commodityMapper;

    public CommodityServiceImpl(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
    }

    @Override
    public CommodityDTO findCommodity(String commodityCode) {
        return commodityMapper.findCommodity(commodityCode);
    }
}
