package com.zjx.myhystrix;

import com.netflix.hystrix.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description 线程隔离-线程池
 * @Author Carson Cheng
 * @Date 2020/3/13 10:14
 * @Version V1.0
 **/
public class CommandUsingThread extends HystrixCommand<List> {


    public CommandUsingThread(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ThreadPoolTestGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(name))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionTimeoutInMilliseconds(5000)
                )
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                // 配置队列大小
                                .withMaxQueueSize(10)
                                // 配置线程池里的线程数
                                .withCoreSize(2)
                )
        );
    }

    @Override
    protected List run() throws Exception {
        System.out.println("获取订单列表");
        return getOrderList();
    }

    private List getOrderList() {
        return Arrays.asList(new String[]{"iphone", "huawei"});
    }

    public static void main(String[] args) {
        // final List list = new CommandUsingThread("hystrix-order").execute();

        Future<List> future =new CommandUsingThread("hystrix-order").queue();
        List list = null;
        try {
            list = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        list.forEach(x -> System.out.println(x.toString()));
    }

}
