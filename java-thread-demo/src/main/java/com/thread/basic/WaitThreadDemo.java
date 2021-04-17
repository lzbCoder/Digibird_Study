package com.thread.basic;

/**
 * @program: Digibird_Study
 * @description: wait()方法
 * @author: lzb
 * @create: 2021-03-31 07:43
 **/
public class WaitThreadDemo {

    private static Object person = new Object();

    public static void main(String[] args) {

       Thread t1 = new Thread(() -> {
           synchronized (person){
               System.out.println("t1 come");
               try {
                   System.out.println("t1 wait");
                   person.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("t1 over");
           }
        });

       Thread t2 = new Thread(() -> {
           synchronized (person){
               System.out.println("t2 come");
               person.notify();
               System.out.println("t2 wait");
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("t2 over");
           }
       });

       t1.start();
       t2.start();

    }

}
