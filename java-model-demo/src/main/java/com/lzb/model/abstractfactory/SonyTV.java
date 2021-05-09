package com.lzb.model.abstractfactory;

/**
 * 索尼电视
 */
public class SonyTV implements TV{
    @Override
    public void see() {
        System.out.println("观看索尼电视机");
    }
}
