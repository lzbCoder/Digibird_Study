package com.lzb.model.staticproxy;

/**
 * 可以理解为这是一个代理商-------在中间转手一下
 * 代理模式
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/20
 */
public class ProxyStore implements Store{

    //聚合关系  代理店--工厂店
    private AppleStore store = new AppleStore();

    //如果想要造假    自己在山沟沟里造一个山寨工厂
    private lPhone productlPhone(){
        lPhone lPhone = new lPhone();
        return lPhone;
    }

    //代购  代理------卖手机
    @Override
    public Phone selliPhone(){//可以在真正用户不知情的情况下修改执行的过程
        //1.有一台手机????  真机  找工厂店
        Phone iPhone = this.store.selliPhone();
        //2.有一个山寨工厂     山寨手机
        Phone lPhone = this.productlPhone();
        //3.手机卖出去
//        return iPhone;
        return lPhone;
    }
}
