package com.thread.basic;

/**
 * @program: Digibird_Study
 * @description: 测试sleep方法只能让当前线程睡眠
 * @author: lzb
 * @create: 2021-03-31 06:29
 **/
public class SleepThreadDemo02 {

    public static void main(String[] args) {
        Runner runner = new Runner();
        //1.启动runner线程
        runner.start();
        try {
            //2.使用类名.sleep()，这里使用的是Runner，但睡眠的是main线程
            Runner.sleep(3000);
            System.out.println("当前运行的线程名称" + Runner.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("main thread");
        }
    }
}

class Runner extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("run thread" + i);
        }
    }
}
