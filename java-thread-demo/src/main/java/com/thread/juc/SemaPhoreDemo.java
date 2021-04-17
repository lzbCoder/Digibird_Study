package com.thread.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import java.util.concurrent.Semaphore;

/**
 * 该类{@code SemaPhoreDemo}用于对{@code java}并发包下的
 *    {@link Semaphore}的功能进行演示。
 *
 * <p>{@code Semaphore}可以控制某个共享资源可被同时访问的线程个数，即
 * 可以维护当前访问某一共享资源的线程个数,并提供了同步机制。通过
 * {@code acquire()}方法获取一个许可，如果没有就等待，使用{@code release()}
 * 方法释放一个许可。</p>
 *
 * @author lzb
 * @since 2021/4/15
 * @version 1.0
 **/
public class SemaPhoreDemo {

    /** 定义创建线程数量 */
    private static final Integer THREAD_COUNT = 10;

    /**
     * 该方法用于对{@code Semaphore}的作用进行演示。
     *
     * <p>创建一个有5个许可数的信号量对象，再创建10个线程，
     * 每个线程中都有获取许可和释放许可的方法。由于只有5个许可，因此，
     * 只能有5个线程并发。当5个线程中有一个释放许可，则第6个线程才会
     * 获取许可。依次类推，则一直保证有5个并发线程。</p>
     */
    public static void main(String[] args) {
        // 创建信号量对象，初始化为5。表示有5个许可数
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < THREAD_COUNT; i++) {
            new Pay(semaphore).start();
        }

    }

    static class Pay extends Thread {
        /** 定义日志记录器logger,用于打印日志 */
        private final Logger LOGGER = LoggerFactory.getLogger(Pay.class);

        Semaphore semaphore;

        public Pay(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                //获取许可
                semaphore.acquire();
                //执行任务
                LOGGER.info("[{}] 正在进行支付",Thread.currentThread().getName());
                Thread.sleep(new Random().nextInt(5000));
                //释放许可
                semaphore.release();
                LOGGER.info("[{}] 支付完成",Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}




