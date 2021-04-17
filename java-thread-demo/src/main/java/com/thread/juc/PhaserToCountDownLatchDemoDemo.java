package com.thread.juc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Phaser;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/14
 */
public class PhaserToCountDownLatchDemoDemo {
    private static final int COUNT = 5;

    public static void main(String[] args) throws Exception {
        //创建Semaphore信号量，初始化许可大小为6
        Phaser phaser = new Phaser(6);
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Task(phaser)).start();
        }

        System.out.println("input enter");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();

        // 到达并退出
        phaser.arriveAndDeregister();
        // 5

        // 5 + 1
        phaser.bulkRegister(1);

    }
}

class Task implements Runnable {

    Phaser phaser;

    public Task(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName());
        }
    }

}
