package com.thread.threechara;

import org.apache.log4j.Logger;

/**
 * @author: lzb
 * @create: 2021-04-07 07:03
 */
public class ThreadVisibility {

    private static Logger logger = Logger.getLogger(ThreadVisibility.class);

    public static void main(String[] args) throws InterruptedException {
        //创建一个子线程
        VisibilityThread thread = new VisibilityThread();
        thread.start();
        //主线程睡眠，让子线程执行
        Thread.sleep(2000);
        //改变flag的值
        thread.setFlag(false);
        //主线程睡眠，让子线程执行
        Thread.sleep(1000);
        logger.info("flag为" + thread.flag);
//        System.out.println("flag为" + thread.flag);
    }

    /**
     * 创建一个子线程类
     */
    static class VisibilityThread extends Thread{

        //情况一：不加volatile
        private boolean flag = true;
        //情况二：加volatile，对其他线程可见
//        private volatile boolean flag = true;

        @Override
        public void run() {
            logger.info("线程开始运行");
//            System.out.println("线程开始运行");
            while (true){
                if(!flag){
                    logger.info("退出循环");
//                    System.out.println("退出循环");
                    break;
                }
            }
            logger.info("线程结束运行");
//            System.out.println("线程结束运行");
        }

        public boolean getFlag(){
            return flag;
        }
        public void setFlag(boolean flag){
            this.flag = flag;
        }
    }
}
