package com.thread.threechara;

import org.apache.log4j.Logger;

/**
 * @author: lzb
 * @create: 2021-04-08 13:06
 */
public class ThreadVisibility02 {

    private static Logger logger = Logger.getLogger(ThreadVisibility02.class);

    //共享变量
    private volatile static Boolean flag = false;

    public static void main(String[] args) {

        //线程t1
        Thread t1 = new Thread(() -> {
            while(!flag){
                //方式一：
//                logger.info("abc");
                //方式二：
//                System.out.println("abc");
                //方式三：
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            logger.info("线程"+Thread.currentThread().getName()+"的flag状态为"+flag);
        },"t1");
        t1.start();

        //主线程休眠，让上面子线程先执行
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //线程t2
        Thread t2 = new Thread(() -> {
            logger.info("已进入线程"+ Thread.currentThread().getName());
            //修改flag的值
            flag = true;
            logger.info("线程" + Thread.currentThread().getName()+"将flag置为true");
        },"t2");

        t2.start();
    }

}
