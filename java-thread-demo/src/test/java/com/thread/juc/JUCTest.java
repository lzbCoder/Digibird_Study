package com.thread.juc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 该类主要针对java线程中的一些工具类进行测试
 *
 * @author lzb
 * @version 1.0
 */
public class JUCTest {

    /** 定义日志记录器logger，用于打印日志 */
    private final Logger LOGGER = LoggerFactory.getLogger(JUCTest.class);
    /** 线程计数器对象，初始化为5 */
    private final CountDownLatch latch = new CountDownLatch(5);

    /**
     * 这个方法是对JUC中的CountDownLatch进行测试。
     *
     * <p>CountDownLatch:具有计数器的功能，等待其他线程执行完毕，主线程在继续执行。
     * 将线程数量初始化，如初始化为3，每执行完成一条线程，调用countDown()使计数器减1，
     * 主线程调用方法await()使其等待，当计数器为0时才被执行。
     *
     * @throws InterruptedException
     *         当有中断发生时，则抛出该异常
     * @see InterruptedException
     * @date 2021/4/11 18:09
     */
    @Test
    public void testCountDownLatch() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
                LOGGER.info("当前线程id:"+Thread.currentThread().getId());
                latch.countDown();
            },"线程"+i).start();
        }
        latch.await();
        Assertions.assertEquals(0,latch.getCount());
    }

    /**
     * 这个方法是对JUC中的CyclicBarrier进行测试。
     *
     * <p>CyclicBrrier,翻译过来就是循环栅栏的意思，其作用就是多线程的进行阻塞，
     * 等待某一个临界值条件满足后，同时执行。而<code>CountDownLatch</code>作用是
     * 一个线程(或者多个)，等待另外N个线程完成某个事情之后才能执行。参考
     * {@link java.util.concurrent.CountDownLatch}
     *
     * @date 2021/4/12 7:03
     */
    @Test
    public void testCyclicBarrier(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()->{
            System.out.println("本轮结束！！");
        });

        for (int i = 0; i < 3; i++) {
            new MyThread(cyclicBarrier).start();
        }
    }



    class MyThread extends Thread {
        CyclicBarrier cyclicBarrier;

        public MyThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + "=执行业务方法");

                    Thread.sleep(new Random().nextInt(10000));

                    cyclicBarrier.await();

//                    System.out.println(Thread.currentThread().getName() + "开始下一轮执行");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
