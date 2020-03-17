package com.zjx.myhystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description 信号量来隔离线程
 * @Author Carson Cheng
 * @Date 2020/3/13 10:35
 * @Version V1.0
 **/
public class CommandUsingSemaphore extends HystrixCommand<String> {

    private final int id;

    public CommandUsingSemaphore(int id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                // since we're doing work in the run() method that doesn't involve network traffic
                // and executes very fast with low risk we choose SEMAPHORE isolation
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
        this.id = id;
    }

    @Override
    protected String run() {
        // a real implementation would retrieve data from in memory data structure
        // or some other similar non-network involved work
        return "ValueFromHashMap_" + id;
    }

    public static void main (String[] args){
        // final String str = new CommandUsingSemaphore(1).execute();

        try {
            final Future<String> future = new CommandUsingSemaphore(1).queue();
            final String str = future.get();
            System.out.println(str);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
