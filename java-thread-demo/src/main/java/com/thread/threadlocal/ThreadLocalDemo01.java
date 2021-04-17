package com.thread.threadlocal;

/**
 * @program: Digibird_Study
 * @description: ThreadLocal详解
 * @author: lzb
 * @create: 2021-03-31 23:15
 **/
public class ThreadLocalDemo01 {

    private static Integer num = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                num += 5;
                System.out.println(Thread.currentThread().getName()+":"+num);
            },"Thread" + i);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
