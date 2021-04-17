package com.thread.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 该类{@code CyclicBarrierDemo}是对
 * {@link java.util.concurrent.CyclicBarrier}进行简单的练习。
 *
 * <p>该类的作用就是将多线程进行阻塞，等待某一个临界值条件满足后，同时执行！
 * 假设有一个场景：每个线程代表一个跑步运动员，当运动员都准备好后，
 * 才一起出发，只要有一个人没有准备好，大家都等待！</p>
 *
 * <p>该类与{@link java.util.concurrent.CountDownLatch}异同点：
 * <ul>
 *     <li>相同点：都有让多个线程等待同步然后再开始下一步动作的意思</li>
 *     <li>不同点：CountDownLatch的下一步的动作实施者是主线程，具有不可重复性；
 *     而CyclicBarrier的下一步动作实施者还是“其他线程”本身，具有往复多次实施动作的
 *     特点(下面例子中内部类{@code MyThread}中{@code run}方法中使用了
 *     {@code while循环}，体现重复的特点)</li>
 * </ul>
 * </p>
 *
 * @author lzb
 * @see java.util.concurrent.CountDownLatch
 * @since 2021/4/13
 * @version 1.0
 **/
public class CyclicBarrierDemo {

    /** 定义日志记录器logger，用于打印日志 */
    private final static Logger LOGGER = LoggerFactory.getLogger(CountDownLatchDemo.class);
    /** 创建子线程的个数 */
    private static final Integer COUNT = 3;

    /**
     * 该方法实现{@code CyclicBarrier}的功能。
     *
     * <p>定义一个{@code CyclicBarrier}对象，该对象中可以传递两个参数：<br>
     * <ul>
     * <li>参数1：这是一个数值，定义几个线程进行阻塞，等待某一个临界值
     *           条件满足后，同时执行。如：参数为3，表示三个线程同时到达
     *           {@code await}时，一起执行{@code await}下的代码。可循环使用。
     * <li>参数2(可选)：这是一个线程对象，它表示当前面定义的几个线程等待到临界值
     *          条件满足时，这几个线程会先同时执行该线程对象中的{@code run}方法。
     *          然后再执行{@code await}下的代码。
     * </ul>
     *
     * @param args 字符串参数
     */
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT, () -> System.out.println("本轮结束！！"));

        for (int i = 0; i < COUNT; i++) {
            new MyThread(cyclicBarrier).start();
        }
    }

    /**
     * 静态内部类{@code MyThread}继承线程{@link Thread}，用于上面生成子线程
     *
     * @author lzb
     * @since 2021/4/13
     * @version 1.0
     **/
    static class MyThread extends Thread {
        private CyclicBarrier cyclicBarrier;

        public MyThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    LOGGER.info(Thread.currentThread().getName() + "=执行业务方法");
                    //随机定义每个子线程睡眠的时间
                    Thread.sleep(new Random().nextInt(5000));

                    cyclicBarrier.await();

                    LOGGER.info(Thread.currentThread().getName() + "开始下一轮执行");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
