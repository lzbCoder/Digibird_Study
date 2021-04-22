package com.lzb.model.staticproxy;

/**
 * 这个类是苹果专卖店
 * 理解为苹果的工厂-----苹果专卖店销售
 * 前店后厂
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/20
 */
public class AppleStore implements Store{

    //这是一个工厂店-----手机    关系  依赖
    //依赖关系体现  一个类的方法中使用到了另一个类的对象(传参数 方法内创建)

    //生产真机
    //  做事情之前是否需要提供什么条件---参数
    //  做事情之后是否需要留下什么结果---返回值
    private iPhone productPhone(){//可以理解为这个方法是工厂店自己的
        //创建一台手机
        iPhone iPhone = new iPhone("iPhone7","black");
        //将生出来的手机返回出去
        return iPhone;
    }


    @Override
    //卖手机
    //  做事情之前是否需要条件---参数
    //  做事情之后是否需要结果---返回值
    public Phone selliPhone(){
        //找自己的工厂生产一台手机
        iPhone iPhone = this.productPhone();
        //将工厂方法生产的手机返回出去
        return iPhone;
    }
}
