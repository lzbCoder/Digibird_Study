package com.debug.cases;

import com.debug.entry.Box;
import com.debug.entry.Consumer;
import com.debug.entry.Producer;

/**
 * @program: Digibird_Study
 * @description: 生产者消费者模式
 * @author: lzb
 * @create: 2021-03-28 17:20
 **/
public class DebugCase5 {

    public static void main(String[] args) {
        Box box = new Box();
        Producer producer = new Producer(box);
        Consumer consumer = new Consumer(box);

        Thread thread1 = new Thread(producer,"生产者");
        Thread thread2 = new Thread(consumer,"消费者");

        thread1.start();
        thread2.start();

    }
}
