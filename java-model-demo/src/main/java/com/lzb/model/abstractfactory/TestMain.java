package com.lzb.model.abstractfactory;

public class TestMain {

    public static void main(String[] args) {

        //1.先通过工厂生产者创建一个工厂
        //1.1生成一个手机工厂
        AbstractFactory phoneFactory = FactoryProducer.getFactory("phone");
        //1.2生成一个电视工厂
        AbstractFactory tvFactory = FactoryProducer.getFactory("tv");

        //2.通过工厂来获取对应的产品
        //2.1通过手机工厂来获取小米手机
        Phone miPhone = phoneFactory.getPhone("mi");
        //2.2通过手机工厂来获取华为手机
        Phone huaPhone = phoneFactory.getPhone("huawei");
        //2.3通过电视工厂来获取索尼电视
        TV sonyTV = tvFactory.getTV("sony");
        //2.4通过电视工厂来获取三星电视
        TV samSungTV = tvFactory.getTV("samsung");

        //3.调用具体方法
        miPhone.call();
        huaPhone.call();
        sonyTV.see();
        samSungTV.see();

    }
}
