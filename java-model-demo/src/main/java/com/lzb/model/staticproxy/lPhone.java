package com.lzb.model.staticproxy;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/20
 */
public class lPhone implements Phone{

    @Override
    public void call(){
        System.out.println("假的lPhone 打电话很卡顿");
    }
    @Override
    public void play(){
        System.out.println("假的lPhone 玩游戏很烫手");
    }
    @Override
    public void photo(){
        System.out.println("假的lPhone 拍照片很模糊");
    }
}
