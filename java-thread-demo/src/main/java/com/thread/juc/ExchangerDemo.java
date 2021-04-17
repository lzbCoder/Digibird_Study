package com.thread.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.Exchanger;


/**
 *该类{@code ExchangerDemo}用于对{@code java}并发包下的
 * {@link Exchanger}的功能进行演示。
 *
 * <p>{@code Exchanger}用于两个线程之间数据的同步交换，仅限于两个线程之间。
 *
 * <p>Exchanger用于进行线程间的数据交换。它提供一个同步点，在这个同步点
 * 两个线程可以交换彼此的数据。这两个线程通过{@code exchange}方法交换数据，
 * 如果第一个线程先执行{@code exchange}方法，它会一直等待第二个线程也执行exchange，
 * 当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据
 * 传递给对方。因此使用{@code Exchanger}的重点是成对的线程使用{@code exchange()}
 * 方法，当有一对线程达到了同步点，就会进行交换数据。因此该工具类的线程对象是成对的
 * </p>
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/14
 */
public class ExchangerDemo {

    /**
     * 该方法用于对{@code Exchanger}的作用进行演示。
     *
     * <p>创建{@code Exchanger}对象，再创建两个线程，创建线程时，
     * 将{@code Exchanger}对象注入到线程中，使两个线程中都拥有同一个
     * {@code Exchanger}对象，目的是为了在线程中使用{@code Exchanger}对象中
     * 的{@code exchange()}方法。当两个线程都执行到{@code exchange()}方法处，
     * 则将两个线程中{@code exchange()}方法中的信息传递给对方。</p>
     *
     */
    public static void main(String[] args) {
        //创建Exchanger对象，支持泛型
        Exchanger<String> exchanger = new Exchanger<>();
        //启动两个线程
        new Thread1(exchanger).start();
        new Thread2(exchanger).start();
    }
}

class Thread1 extends Thread {
    /** 定义日志记录器logger,用于打印日志 */
    private final Logger LOGGER = LoggerFactory.getLogger(Thread1.class);

    Exchanger<String> exchanger;

    public Thread1(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        LOGGER.info("Thread1 run");

        try {
            String str = exchanger.exchange("Thread1 --> Thread2的数据");

            LOGGER.info("Thread1 exchanger = [{}]",str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends Thread {

    /** 定义日志记录器logger,用于打印日志 */
    private final Logger LOGGER = LoggerFactory.getLogger(Thread2.class);

    Exchanger<String> exchanger;

    public Thread2(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        LOGGER.info("Thread2 run");

        try {
            String str = exchanger.exchange("Thread2 ==> Thread1的数据");
            LOGGER.info("Thread2 exchanger = [{}]",str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
