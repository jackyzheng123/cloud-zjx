package com.zjx.controller;

import com.zjx.dto.CommodityDTO;
import com.zjx.service.CommodityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 12:04
 * @Version V1.0
 **/
@RestController
public class CommodityController {

    private final CommodityService commodityService;

    public CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/findCommodity")
    public CommodityDTO findCommodity(@RequestParam String commodityCode) {
        return commodityService.findCommodity(commodityCode);
    }
}
