package com.lzb.model.staticproxy;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/20
 */
public class iPhone implements Phone{

    //描述属性
    private String name;
    private String color;

    //构造方法
    public iPhone(){}
    public iPhone(String name,String color){
        this.name=name;
        this.color=color;
    }

    //打电话
    @Override
    public void call(){
        System.out.println("真的iPhone 打电话很流畅");
    }
    //玩游戏
    @Override
    public void play(){
        System.out.println("真的iPhone 玩游戏不卡顿");
    }
    //拍照片
    @Override
    public void photo(){
        System.out.println("真的iPhone 拍照片很清晰");
    }

}
