package com.thread.interrupt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 该类针对线程中断interrupt方法的测试
 *
 * @author lzb
 * @version 1.0
 * @date 2021/4/11
 **/
public class ThreadInterruptTest {

    /** 获取日志记录器，用于打印日志 */
    private final Logger LOGGER = LoggerFactory.getLogger(ThreadInterruptTest.class);
    /** 定义一个退出标识，用于测试testFlag，初始值为false */
    private static volatile boolean flag =false;

    /**
     * 测试使用退出标志的方式来中断线程
     *
     * <p>一个线程使用<code>flag</code>状态位为<code>false</code>来运行，
     * 另一个线程改变<code>flag</code>的值，从而中断前一个线程的执行。
     * 这种方式实现了中断线程的目的。同时这也是线程可见性中一个典型例子。
     *
     * @return void
     * @date 2021/4/11 22:41
     */
    @Test
    public void testFlag() {
        //新建子线程。flag为false，循环睡眠(阻塞)
        new Thread(() -> {
            LOGGER.info("线程启动了");
            while (!flag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            LOGGER.info("线程结束了");
        }).start();

        //主线程睡眠，等待子线程执行
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2秒后更改退出标志的值
        flag = true;
        //断言
        Assertions.assertTrue(ThreadInterruptTest.flag);
    }

    /**
     * 测试使用 interrupt() + InterruptedException来中断线程
     *
     * <p>子线程开启，执行中使用<code>sleep()</code>方法进行阻塞，
     * 主线程等待子线程1秒后，准备结束(在测试中，若在main方法中，会使子线程执行结束)，
     * 这时子线程调用<code>interrupt()</code>，将中断状态位设置
     * 为<code>true</code>，由于这是在主线程中执行的，因此是主线程将子线程进行中断，
     * 具体什么时候中断，子线程可以在合适的时候调用interrupted或isInterrupted来
     * 检测状态并做相应的处理。
     *
     * @return void
     * @date 2021/4/11 22:05
     */
    @Test
    public void testInterrupt1(){
        Thread thread = new Thread(() -> {
            LOGGER.info("线程开始执行了");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                LOGGER.error("中断异常",e);
            }
            LOGGER.info("线程结束执行了");
        });
        //子线程开启
        thread.start();
        //主线程等待子线程1秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("中断异常",e);
        }
        //中断线程(子线程调用interrupt()方法，是主线程将子线程中断)
        thread.interrupt();
        //断言
        Assertions.assertTrue(ThreadInterruptTest.flag);
    }

    /**
     * 测试使用 interrupt() + isInterrupted()来中断线程<br>
     *
     * <p>isInterrupted(),该方法测试线程是否已经中断，但是不能清除状态标识。
     * 子线程启动后，进入死循环，通过调用<code>interrupt()</code>方法来使
     * 中断状态位变为true，同时利用<code>isInterrupted()</code>方法进行
     * 对状态位的判定。类似于方式一，通过状态位来中断线程。
     *
     * @return void
     * @date 2021/4/12 6:24
     */
    @Test
    public void testInterrupt2(){
        Thread thread = new Thread() {
            public void run() {
                LOGGER.info("线程启动了");
                //中断前，中断状态为false
                LOGGER.info("中断状态为[{}]",isInterrupted());
                while (!isInterrupted()) {}
                //调用interrupt()，中断状态改为true
                LOGGER.info("中断状态为[{}]",isInterrupted());
                LOGGER.info("线程结束了");
            }
        };
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        //断言：isInterrupted()方法返回值是否改变
        Assertions.assertTrue(thread.isInterrupted());
    }




}
