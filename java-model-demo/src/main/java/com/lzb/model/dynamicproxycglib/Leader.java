package com.lzb.model.dynamicproxycglib;

import com.lzb.model.dynamicproxyjdk.IWork;

import java.util.Random;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/22
 */
public class Leader{

    public void meeting() {
        System.out.println("领导早上要组织会议");
    }


    public int evaluate(String name) {
        int score = new Random(System.currentTimeMillis()).nextInt(20) + 80;
        System.out.println(String.format("领导给%s的考评为%s分", name, score));
        return score;
    }
}
