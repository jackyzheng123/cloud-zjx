package com.zjx.service;

import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 10:58
 * @Version V1.0
 **/
@Component
@Slf4j
public class ServiceCFallback implements ServiceCClient {

    @Override
    public String rpc(String name) {
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return "service-c fallback";
    }
}
