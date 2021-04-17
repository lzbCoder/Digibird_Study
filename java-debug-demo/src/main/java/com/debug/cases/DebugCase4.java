package com.debug.cases;

/**
 * @program: Digibird_Study
 * @description: 多线程调试：首先调整断点挂起级别为Thread
 * @author: lzb
 * @create: 2021-03-28 17:02
 **/
public class DebugCase4 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(),"张三");
        Thread thread2 = new Thread(new MyRunnable(),"李四");
        Thread thread3 = new Thread(new MyRunnable(),"王五");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "___进入");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "___离开");
    }
}
