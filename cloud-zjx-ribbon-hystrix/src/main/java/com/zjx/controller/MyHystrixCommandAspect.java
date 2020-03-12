package com.zjx.controller;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2020/3/12 16:32
 * @Version V1.0
 **/
@Aspect
@Component
public class MyHystrixCommandAspect {

    private ExecutorService executor = Executors.newFixedThreadPool(10);

    @Pointcut(value = "@annotation(MyHystrixCommand)")
    public void pointCut() {

    }

    @Around(value = "pointCut()&&@annotation(hystrixCommand)")
    public Object doProcess(ProceedingJoinPoint joinPoint, MyHystrixCommand hystrixCommand) throws Throwable {
        int timeout = hystrixCommand.value();
        Future future = executor.submit(() -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return null;
        });

        Object returnValue = null;
        try {
            returnValue = future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            future.cancel(true);
            if (StringUtils.isBlank(hystrixCommand.fallback())) {
                throw new Exception("fallback is null");
            }
            returnValue = invokeFallbackMethod(joinPoint, hystrixCommand.fallback());
        }
        return returnValue;
    }

    private Object invokeFallbackMethod(ProceedingJoinPoint joinPoint, String fallback) throws Exception {
        Method fallbackMethod = findFallbackMethod(joinPoint, fallback);
        if (fallbackMethod == null) {
            throw new Exception("can not find fallback :" + fallback + " method");
        } else {
            fallbackMethod.setAccessible(true);
            try {
                Object invoke = fallbackMethod.invoke(joinPoint.getTarget(), joinPoint.getArgs());
                return invoke;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Method findFallbackMethod(ProceedingJoinPoint joinPoint, String fallback) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        Class<?>[] parameterTypes = method.getParameterTypes();
        Method fallbackMethod = null;
        try {
            fallbackMethod = joinPoint.getTarget().getClass().getMethod(fallback, parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return fallbackMethod;
    }

}
