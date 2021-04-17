package com.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/16
 */
public class ReentrantLockDemo01 {

    public static void main(String[] args) throws Exception {


        // 互斥锁 可重入锁
        ReentrantLock lock = new ReentrantLock();


        Thread thread = new Thread(new T1(lock));
        thread.start();

        Thread.sleep(4000);
        thread.interrupt();

        //5秒内可以拿到锁，tryLock()就会返回true
        System.out.println("========================================" + lock.tryLock(5, TimeUnit.SECONDS));
    }
}

class T1 implements Runnable {

    ReentrantLock lock;

    public T1(ReentrantLock lock) {
        this.lock = lock;
    }

    int v = 1;

    @Override
    public void run() {
        try {
            v1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    void test() {
        lock.lock();
        try{
            Thread.sleep(1000);
            System.out.println("test==================================");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void v1() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            for (int i = 0; i < 60; i++) {
//                test();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " , val = " + v++);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }
}
