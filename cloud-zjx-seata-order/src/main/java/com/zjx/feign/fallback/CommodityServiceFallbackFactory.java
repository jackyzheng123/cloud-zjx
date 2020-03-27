package com.zjx.feign.fallback;

import com.zjx.dto.CommodityDTO;
import com.zjx.feign.CommodityServiceClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/25 11:19
 * @Version V1.0
 **/
@Component
@Slf4j
public class CommodityServiceFallbackFactory implements FallbackFactory<CommodityServiceClient> {

    @Override
    public CommodityServiceClient create(Throwable throwable) {
        return new CommodityServiceClient() {
            @Override
            public CommodityDTO findCommodity(String commodityCode) {
                log.error("查询商品失败，", throwable);
                return null;
            }
        };
    }

}
