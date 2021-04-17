package com.thread.basic;

/**
 * @program: Digibird_Study
 * @description: sleep方法的使用
 * @author: lzb
 * @create: 2021-03-31 06:02
 **/
public class SleepThreadDemo01 {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("当前运行的线程名称" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("end" + i);
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            System.out.println("start" + i);
        }
    }
}
