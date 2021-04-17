package com.debug.entry;

/**
 * @program: Digibird_Study
 * @description: 消费者线程
 * @author: lzb
 * @create: 2021-03-28 17:23
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
