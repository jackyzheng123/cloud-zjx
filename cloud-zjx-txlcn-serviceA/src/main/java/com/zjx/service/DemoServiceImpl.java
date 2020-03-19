package com.zjx.service;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tracing.TracingContext;
import com.zjx.domain.Demo;
import com.zjx.mapper.DemoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Objects;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/19 14:13
 * @Version V1.0
 **/
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    private final DemoMapper demoMapper;

    private final ServiceBClient serviceBClient;

    private final ServiceCClient serviceCClient;

    private final RestTemplate restTemplate;

    @Autowired
    public DemoServiceImpl(DemoMapper demoMapper, ServiceBClient serviceBClient, ServiceCClient serviceCClient, RestTemplate restTemplate) {
        this.demoMapper = demoMapper;
        this.serviceBClient = serviceBClient;
        this.serviceCClient = serviceCClient;
        this.restTemplate = restTemplate;
    }

    @Override
    public String execute(String value, String exFlag) {
        // step1. call remote ServiceB
        // String bResp = restTemplate.getForObject("http://127.0.0.1:12011/rpc?value=" + value, String.class);
        String bResp = serviceBClient.rpc(value);

        // step2. call remote ServiceC
        String cResp = serviceCClient.rpc(value);

        // step3. execute local transaction
        Demo demo = new Demo();
        demo.setGroupId(TracingContext.tracing().groupId());
        demo.setDemoField(value);
        demo.setCreateTime(new Date());
        demo.setAppName(Transactions.getApplicationId());
        demoMapper.save(demo);

        // 置异常标志，DTX 回滚
        if (Objects.nonNull(exFlag)) {
            throw new IllegalStateException("by exFlag");
        }

        return bResp + " > " + cResp + " > " + "ok-service-a";
    }
}