package com.zjx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/23 17:16
 * @Version V1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GatewayRateLimitApplication.class)
public class RateLimitTest {

    final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 并发测试
     */
    @Test
    public void test() {
        int num = 100;
        CountDownLatch latch = new CountDownLatch(num);

        for (int i = 0; i < num; i++) {
            latch.countDown();

            new Thread(() -> {
                final String result = restTemplate.getForObject("http://localhost:8081/get", String.class);
                log.info("result: " + result);
            }).start();
        }

        try {
            latch.await();
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
