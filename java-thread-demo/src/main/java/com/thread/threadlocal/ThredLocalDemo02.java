package com.thread.threadlocal;

import sun.rmi.server.InactiveGroupException;

/**
 * @program: Digibird_Study
 * @description:
 * @author: lzb
 * @create: 2021-03-31 23:44
 **/
public class ThredLocalDemo02 {

    //定义一个静态变量(共享)，使用ThreadLocal进行封装
    private static ThreadLocal<Integer> numLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 0;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int x = numLocal.get().intValue();
                x += 5;
                numLocal.set(x);
                System.out.println(Thread.currentThread().getName()+":"+numLocal.get());
            },"Thread" + i);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

}
