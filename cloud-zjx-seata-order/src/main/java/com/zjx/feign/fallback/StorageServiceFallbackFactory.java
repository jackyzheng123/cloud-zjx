package com.zjx.feign.fallback;

import com.zjx.feign.StorageServiceClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/25 11:13
 * @Version V1.0
 **/
@Component
@Slf4j
public class StorageServiceFallbackFactory implements FallbackFactory<StorageServiceClient> {

    @Override
    public StorageServiceClient create(Throwable cause) {
        return new StorageServiceClient() {

            @Override
            public void deduct(String commodityCode, Integer count) {
                log.error("扣减库存失败，" + cause);
            }

        };
    }
}
