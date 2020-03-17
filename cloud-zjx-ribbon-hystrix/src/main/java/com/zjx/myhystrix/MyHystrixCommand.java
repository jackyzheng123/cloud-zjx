package com.zjx.myhystrix;

import java.lang.annotation.*;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/12 16:28
 * @Version V1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyHystrixCommand {

    /**
     * timeout 默认100毫秒
     * @return
     */
    int value() default 100;

    /**
     * 指定fallback方法
     * @return
     */
    String fallback() default "";
}
