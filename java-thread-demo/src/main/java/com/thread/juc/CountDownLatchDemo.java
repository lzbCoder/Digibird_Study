package com.thread.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * 该类{@code CountDownLatchDemo}用于对{@code java}并发包下的
 * {@link CountDownLatch}的功能进行演示。
 *
 * <p>线程计数器：用于监听某些初始化操作，并且线程进行阻塞，
 * 等初始化执行完毕后，通知主线程继续工作执行。
 *
 * @author lzb
 * @see CountDownLatch
 * @since 2021/4/13
 * @version 1.0
 **/
public class CountDownLatchDemo {

    /** 定义日志记录器logger，用于打印日志 */
    private final static Logger LOGGER = LoggerFactory.getLogger(CountDownLatchDemo.class);
    /**线程计数器对象，初始化为5 {@value} */
    private static final CountDownLatch LATCH = new CountDownLatch(5);


    /**
     * 这个方法是对JUC中的CountDownLatch进行测试。
     *
     * <p>将线程数量初始化，每执行完成一条线程，调用countDown()使计数器减1，
     * 主线程调用方法await()使其等待，当计数器为0时才被执行。
     *
     * @throws InterruptedException
     *         当有中断发生时，则抛出该异常
     * @see InterruptedException
     * @param args 字符串参数
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < LATCH.getCount(); i++) {
            new Thread(() ->{
                LOGGER.info("当前线程id:"+Thread.currentThread().getId());
                LATCH.countDown();
            },"线程"+i).start();
        }
        LATCH.await();
    }

}
