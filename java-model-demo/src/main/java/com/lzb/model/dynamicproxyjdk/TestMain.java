package com.lzb.model.dynamicproxyjdk;

import java.lang.reflect.Proxy;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/22
 */
public class TestMain {
    public static void main(String[] args) {

        Leader leader = new Leader();
        IWork proxy = (IWork) Proxy.newProxyInstance(Leader.class.getClassLoader(),
                                                     new Class[]{IWork.class},
                                                     new
                                                             WorkInvocationHandler(leader));
        proxy.meeting();
        proxy.evaluate("Joy");
        proxy.evaluate("James");
    }

    /*
      //0.类加载器---目的是把需要代理的AppleStore这个类加载进来
      ClassLoader classLoader = clazz.getClassLoader();
      //1.代理谁(被代理对象实现的所有接口)，数组
      Class[] classes = new Class[]{clazz};
      //2.代理他之后 具体该做什么事情
      重写InvocationHandler接口中的invoke方法
      invoke方法中的三个参数：//1.proxy代理对象  2.method代理的那个方法  3.args代理方法传递的参数
     */

}
