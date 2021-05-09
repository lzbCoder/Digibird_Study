package com.lzb.model.factorymethod;

public class TestMain {

    public static void main(String[] args) {
        //创建一个工厂对象
        BarbecueFactory factory = new BarbecueFactoryA();
        //通过工厂来获取一个烧烤店
        BarbecueShop shop = factory.getBarbecueShop();
        //调用方法
        shop.saleKebab();
    }
}
