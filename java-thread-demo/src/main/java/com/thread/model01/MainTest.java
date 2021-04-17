package com.thread.model01;

/**
 * @program: Digibird_Study
 * @description:
 * @author: lzb
 * @create: 2021-04-01 22:39
 **/
public class MainTest {

    public static void main(String[] args) {
        Box box = new Box();
        Consumer consumer = new Consumer(box);
        Producer producer = new Producer(box);

        Thread thread1 = new Thread(consumer,"消费者");
        Thread thread2 = new Thread(producer,"生产者");

        thread1.start();
        thread2.start();
    }
}
