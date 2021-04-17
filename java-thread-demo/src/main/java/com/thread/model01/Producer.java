package com.thread.model01;

/**
 * @program: Digibird_Study
 * @description:
 * @author: lzb
 * @create: 2021-04-01 09:42
 **/
public class Producer implements Runnable{

    private Box box;
    public Producer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            box.put(i);
        }
    }
}
