package com.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/19
 */
public class AspectOne {

    /**
     * AspectOne的前置通知
     */
    public void beforeMethod(){
        System.out.println("切面1的前置通知");
    }

    /**
     * AspectOne的后置通知
     */
    public void afterReturningMethod(){
        System.out.println("切面1的后置通知");
    }

    /**
     * AspectOne的环绕通知
     *   该通知与其他几个不同，它特别像是以前的Filter (底层责任链实现方式)
     *   下面代码pjp.proceed(); 像 chain.doFilter();
     */
    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("切面1的环绕通知前");
        //中间等待目标执行完
        pjp.proceed();
        System.out.println("切面1的环绕通知后");
    }

    /**
     * AspectOne的异常通知
     */
    public void afterThrowingMethod(){
        System.out.println("切面1的异常通知");
    }

    /**
     * AspectOne的最终通知
     */
    public void afterMethod(){
        System.out.println("切面1的最终通知");
    }

}
