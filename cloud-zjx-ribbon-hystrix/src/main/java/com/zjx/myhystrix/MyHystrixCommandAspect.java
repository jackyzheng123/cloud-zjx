package com.zjx.myhystrix;

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

    /**
     * 自定义HystrixCommand注解切点
     */
    @Pointcut(value = "@annotation(com.zjx.myhystrix.MyHystrixCommand)")
    public void pointCut() {

    }

    @Around(value = "pointCut()&&@annotation(hystrixCommand)")
    public Object doProcess(ProceedingJoinPoint joinPoint, MyHystrixCommand hystrixCommand) throws Throwable {
        int timeout = hystrixCommand.value();
        // 另起线程执行目标方法
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
            // 默认的timeout时间返回结果
            returnValue = future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            // 取消任务
            future.cancel(true);
            if (StringUtils.isBlank(hystrixCommand.fallback())) {
                throw new Exception("fallback is null");
            }
            // 执行fallback方法，返回结果
            returnValue = invokeFallbackMethod(joinPoint, hystrixCommand.fallback());
        }
        return returnValue;
    }

    /**
     * 执行fallback方法
     * @param joinPoint
     * @param fallback fallback方法字符
     * @return 执行fallback方法返回结果
     * @throws Exception
     */
    private Object invokeFallbackMethod(ProceedingJoinPoint joinPoint, String fallback) throws Exception {
        // 查找fallback方法
        Method fallbackMethod = findFallbackMethod(joinPoint, fallback);
        if (fallbackMethod == null) {
            throw new Exception("can not find fallback :" + fallback + " method");
        } else {
            fallbackMethod.setAccessible(true);
            try {
                // 执行fallback方法
                Object invoke = fallbackMethod.invoke(joinPoint.getTarget(), joinPoint.getArgs());
                return invoke;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 查找fallback方法
     * @param joinPoint
     * @param fallback fallback方法字符
     * @return fallback方法
     */
    private Method findFallbackMethod(ProceedingJoinPoint joinPoint, String fallback) {
        // 执行目标的方法
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        // 执行目标的方法的参数列表
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method fallbackMethod = null;
        try {
            // 获取fallback方法
            fallbackMethod = joinPoint.getTarget().getClass().getMethod(fallback, parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return fallbackMethod;
    }

}
