package com.thread.threadpool;

import org.apache.log4j.Logger;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;


/**
 * 线程池
 * @author: lzb
 * @create: 2021-04-08 04:32
 */
public class ThreadPoolDemo {

    private static Logger logger = Logger.getLogger(ThreadPoolDemo.class);

    public static void main(String[] args) throws Exception{
        //1 可缓存线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() -> {
            logger.info("可缓存线程池");
        });

        //2 定长线程池：确定线程个数
        pool = Executors.newFixedThreadPool(10);
        pool.execute(() -> {
            logger.info("定长线程池");
        });

        //3 单线程线程池
        pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> {
            logger.info("单线程线程池");
        });

        //4 计划任务线程池
        //参数：
        // delay：表示延迟的时间
        // TimeUnit.SECONDS：表示时间单位
        ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(10);
        //表示延迟3秒后，执行线程中的run方法
        pool2.schedule(() -> {
            logger.info("计划任务线程池");
        },3, TimeUnit.SECONDS);


//        corePoolSize, 核心线程数：创建线程池时初始化的线程数
//        maximumPoolSize, 最大线程数量：能够支持并发执行的最大线程数
//        keepAliveTime, 线程保持等待任务的最大空余时间(若线程池核心线程数为10，当有100个任务时，创建100个线程执行，当执行结束，并不是立马就销毁90个线程，保持核心线程数，而是当执行完任务后，根据该参数设置的值，等待该时间后，若还是没有任务，则会将销毁90个线程，让线程池中保持核心线程数)
//        unit 时间单位
//        workQueue, 阻塞队列。存放还没有执行的任务队列。(当设置最大线程数为100，有许多任务，这100个线程一直在执行，当任务过多，没有可用线程去执行，因此将这些任务放到阻塞队列中，等待有线程空闲后来执行阻塞队列中的任务)
//        Executors.defaultThreadFactory(), 创建线程的工厂。(当线程池去创建线程时，是通过什么方式去创建)

//        defaultHandler 拒绝策略
//        丢弃任务抛出异常
//        丢弃任务，不抛出异常
//        丢弃队列最前面的任务
//        由调用线程处理该任务
        //5 自定义线程池
        ExecutorService mypool = new ThreadPoolExecutor(
                5,
                10,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue(50),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        //创建线程时的方式
        //上面我们用的都是线程池的execute方法，在该方法中传递实现Runnable接口的线程。
        //还有一种方式：使用线程池中的submit方法，传递实现Callable接口的线程。

        //区别在于：使用Callable来创建线程，当线程执行结束后，会有一个Future类型的返回值
        Future<String> future1 = mypool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Callable";
            }
        });

        Future future2 = mypool.submit(new Runnable() {
            @Override
            public void run() {
//                return "Runnable";
                logger.info("Runnable");
            }
        });

        //通过Future对象来获得线程执行的结果
        String res1 = future1.get();
        logger.info("future=" + res1);

        Object res2 = future2.get();
        logger.info("future=" + res2);

    }
}
