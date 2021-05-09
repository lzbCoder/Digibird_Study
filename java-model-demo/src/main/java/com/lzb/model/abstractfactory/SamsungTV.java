package com.lzb.model.abstractfactory;

/**
 * 三星电视机
 */
public class SamsungTV implements TV{
    @Override
    public void see() {
        System.out.println("观看三星电视机");
    }
}
