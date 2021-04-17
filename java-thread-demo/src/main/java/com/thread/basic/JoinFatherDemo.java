package com.thread.basic;

/**
 * @program: Digibird_Study
 * @description:    测试Join方法，为Join方法中指代的父线程
 * @author: lzb
 * @create: 2021-03-31 13:11
 **/
public class JoinFatherDemo extends Thread{

    @Override
    public void run() {
        System.out.println("father start");
        //在JoinFatherDemo线程中创建JoinSonDemo线程对象
        JoinSonDemo sonDemo = new JoinSonDemo();
        //在JoinFatherDemo线程中调用JoinSonDemo线程
        sonDemo.start();
        try {
            //将JoinSonDemo线程加到JoinFatherDemo线程中
            sonDemo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("father end");
    }
}
