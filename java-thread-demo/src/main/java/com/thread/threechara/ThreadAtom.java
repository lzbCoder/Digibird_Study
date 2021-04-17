package com.thread.threechara;

import org.apache.log4j.Logger;

public class ThreadAtom {
    private static Logger logger = Logger.getLogger(ThreadAtom.class);
    private static Object obj = new Object();
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    synchronized (obj){
                        count ++;
                    }
//                    count ++;
                }
            });
            thread.start();
        }
        //主线程休眠，等待子线程执行
        Thread.sleep(2000);
        logger.info(count);
    }
}
