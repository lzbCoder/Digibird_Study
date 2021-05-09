package com.lzb.model.abstractfactory;

public class MiPhone implements Phone{

    @Override
    public void call() {
        System.out.println("使用小米手机打电话");
    }
}
