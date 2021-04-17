package com.debug.entry;

/**
 * @program: Digibird_Study
 * @description: 生产者线程
 * @author: lzb
 * @create: 2021-03-28 17:24
 **/
public class Producer implements Runnable{
    private Box box;

    public Producer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++){
            box.put(i);
        }
    }
}
