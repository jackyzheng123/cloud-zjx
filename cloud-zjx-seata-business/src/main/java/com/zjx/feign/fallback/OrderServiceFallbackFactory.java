package com.zjx.feign.fallback;

import com.zjx.dto.OrderDTO;
import com.zjx.dto.StorageDTO;
import com.zjx.feign.OrderServiceClient;
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
public class OrderServiceFallbackFactory implements FallbackFactory<OrderServiceClient> {

    @Override
    public OrderServiceClient create(Throwable cause) {
        return new OrderServiceClient() {

            @Override
            public boolean create(String userId, String commodityCode, Integer count) {
                log.error("创建订单失败，" + cause);
                return false;
            }
        };
    }
}
