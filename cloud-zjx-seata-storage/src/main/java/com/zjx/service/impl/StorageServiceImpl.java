package com.zjx.service.impl;

import com.zjx.mapper.StorageMapper;
import com.zjx.service.StorageService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/24 11:48
 * @Version V1.0
 **/
@Service
public class StorageServiceImpl implements StorageService {

    private final StorageMapper storageMapper;

    public StorageServiceImpl(StorageMapper storageMapper) {
        this.storageMapper = storageMapper;
    }

    /**
     * 减库存
     */
    @Override
    public void deduct(String commodityCode, Integer count) {
        // 查库存
        Integer num = storageMapper.queryStorage(commodityCode);
        if (num <= 0) {
            try {
                throw new Exception("库存不足");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 减库存
            storageMapper.deduct(commodityCode, count);
        }
    }
}
