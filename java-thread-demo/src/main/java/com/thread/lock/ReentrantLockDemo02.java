package com.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock实现互斥锁的功能
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/16
 */
public class ReentrantLockDemo02 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            new Thread(new T1(lock)).start();
        }
    }

    static class T1 implements Runnable{

        ReentrantLock lock;

        public T1(ReentrantLock lock){
            this.lock = lock;
        }

        int v = 1;

        @Override
        public void run(){
            v1();
        }

        void v1(){
            //获取锁
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+",val = " + v++);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //释放锁
                lock.unlock();
            }

        }
    }

}
