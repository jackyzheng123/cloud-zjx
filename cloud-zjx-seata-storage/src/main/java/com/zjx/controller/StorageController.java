package com.zjx.controller;

import com.zjx.service.StorageService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 12:04
 * @Version V1.0
 **/
@RestController
public class StorageController {

    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * 减库存
     */
    @PutMapping("/deduct")
    public void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count) {
        storageService.deduct(commodityCode, count);
    }
}
