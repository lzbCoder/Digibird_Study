package com.thread.model01;

/**
 * @program: Digibird_Study
 * @description:
 * @author: lzb
 * @create: 2021-04-01 09:21
 **/
public class Consumer implements Runnable{

    private Box box;
    public Consumer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
       while (true){
           box.get();
       }
    }
}
