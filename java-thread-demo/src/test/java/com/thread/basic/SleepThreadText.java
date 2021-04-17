package com.thread.basic;

import org.junit.jupiter.api.Test;

/**
 * @program: Digibird_Study
 * @description: 测试sleep()方法
 * @author: lzb
 * @create: 2021-03-31 00:11
 **/
public class SleepThreadText {

    @Test
    public void sleepTest1(){

        new Thread(() -> {
            try {
                Thread.sleep(2000);
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

    @Test
    public void sleepTes2() throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("end" + i);
            }
        }).start();

        for (int i = 0; i < 500; i++) {
            System.out.println("start" + i);
        }

        Thread.sleep(5000);
    }


}
