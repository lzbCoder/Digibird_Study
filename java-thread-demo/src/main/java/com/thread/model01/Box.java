package com.thread.model01;

/**
 * @program: Digibird_Study
 * @description:
 * @author: lzb
 * @create: 2021-04-01 09:43
 **/
public class Box {

    private int apple;
    // true表示有苹果，false表示没有苹果
    private boolean state = false;

    public void put(int apple){
        System.out.println("put start");
        //开始对该盒子对象进行操作时，使用synchronized将该盒子对象锁定
        synchronized (this){
            //如果盒子中有苹果，则等待
            if(state){
                try {
                    System.out.println("put wait start");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("put wait end");
            }
            this.apple = apple;
            System.out.println("已经生产出第" + this.apple +"个苹果");
            //盒子中有了苹果，因此需要改变state的状态为true
            this.state = true;
            //唤醒消费者线程，让消费者从盒子中拿苹果
            notifyAll();
        }
        System.out.println("put end");
    }

    public void get(){
        System.out.println("get begin");
        synchronized (this){
            //如果盒子中没有苹果，则等待
            if(!state){
                try {
                    System.out.println("get wait start");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("get wait end");
            }
            System.out.println("消费者拿到了第" + this.apple + "苹果");
            //拿到苹果后，改变state状态为true，让生产者继续生产
            this.state = false;
            //唤醒生产者线程
            notifyAll();
        }
        System.out.println("get end");
    }
}
