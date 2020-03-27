package com.zjx.service.impl;

import com.zjx.mapper.CommodityMapper;
import com.zjx.entity.Commodity;
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

    private final CommodityMapper commodityDAO;

    public CommodityServiceImpl(CommodityMapper commodityDAO) {
        this.commodityDAO = commodityDAO;
    }

    @Override
    public Commodity findCommodity(String commodityCode) {
        return commodityDAO.findCommodity(commodityCode);
    }
}
