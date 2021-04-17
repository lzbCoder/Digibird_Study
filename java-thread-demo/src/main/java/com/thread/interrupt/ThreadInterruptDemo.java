package com.thread.interrupt;

/**
 *
 * @author lzb
 * @since 2021/4/15
 * @version 1.0
 **/
public class ThreadInterruptDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程启动了");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束了");
        });
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }



}
