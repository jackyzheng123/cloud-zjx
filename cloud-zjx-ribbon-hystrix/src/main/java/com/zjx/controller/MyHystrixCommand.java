package com.zjx.controller;

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
     * timeout
     * @return
     */
    int value() default 100;

    /**
     * fallback方法
     * @return
     */
    String fallback() default "";
}
