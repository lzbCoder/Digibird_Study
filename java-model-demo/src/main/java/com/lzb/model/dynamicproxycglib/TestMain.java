package com.lzb.model.dynamicproxycglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/23
 */
public class TestMain {

    public static void main(String[] args) {
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\temp\\code");  //保存生成的 class 文件
        // 通过CGLIB动态代理获取代理对象的过程

        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(Leader.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new LeaderMethodInterceptor());
        // 创建代理对象
        Leader proxy= (Leader)enhancer.create();

        // 通过代理对象调用目标方法
        proxy.meeting();
        proxy.evaluate("Joy");
        proxy.evaluate("James");
    }
}
