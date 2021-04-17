package com.thread.threechara;

import org.junit.jupiter.api.Test;

/**
 * 测试线程的原子性
 * @author: lzb
 * @create: 2021-04-07 13:31
 */
public class ThreeAtomTest {

    private static int count = 0;

    @Test
    public void testAtom1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    count ++;
                    System.out.println("jdof" + count);
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(count);
    }


}
