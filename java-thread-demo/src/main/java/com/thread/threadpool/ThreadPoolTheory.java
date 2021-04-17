package com.thread.threadpool;

import java.util.concurrent.*;

/**
 * 线程池原理解析
 * @author: lzb
 * @create: 2021-04-08 05:51
 */
public class ThreadPoolTheory {

    // 自定义线程池
    ExecutorService mypool = new ThreadPoolExecutor(
            5,
            10,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue(50),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );



}
