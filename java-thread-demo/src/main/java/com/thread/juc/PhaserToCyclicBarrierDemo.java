package com.thread.juc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Phaser;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/16
 */
public class PhaserToCyclicBarrierDemo {

    public static void main(String[] args) throws Exception {


        Phaser phaser = new Phaser(6);
        // 11
        // 10

        for (int i = 0; i < 5; i++) {
            new Thread(new Task2(phaser)).start();
        }

        System.out.println("input enter");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();

        // 到达并退出
        phaser.arriveAndDeregister();
        // 5

        // 5 + 1
//        phaser.bulkRegister(1);


    }
}

class Task2 implements Runnable {

    Phaser phaser;

    public Task2(Phaser phaser) {
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
