package com.thread.basic;

/**
 * @program: Digibird_Study
 * @description:    测试Join方法，为Join方法中指代的子线程
 * @author: lzb
 * @create: 2021-03-31 13:12
 **/
public class JoinSonDemo extends Thread{

    @Override
    public void run() {
        System.out.println("son start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("son end");
    }
}
