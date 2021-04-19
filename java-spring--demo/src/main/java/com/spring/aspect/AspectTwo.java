package com.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/19
 */
public class AspectTwo {

    /**
     * AspectTwo的前置通知
     */
    public void beforeMethod(){
        System.out.println("切面2的前置通知");
    }

    /**
     * AspectTwo的后置通知
     */
    public void afterReturningMethod(){
        System.out.println("切面2的后置通知");
    }

    /**
     * AspectTwo的环绕通知
     *   该通知与其他几个不同，它特别像是以前的Filter (底层责任链实现方式)
     *   下面代码pjp.proceed(); 像 chain.doFilter();
     */
    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("切面2的环绕通知前");
        //中间等待目标执行完
        pjp.proceed();
        System.out.println("切面2的环绕通知后");
    }

    /**
     * AspectTwo的异常通知
     */
    public void afterThrowingMethod(){
        System.out.println("切面2的异常通知");
    }

    /**
     * AspectTwo的最终通知
     */
    public void afterMethod(){
        System.out.println("切面2的最终通知");
    }

}
