package com.lzb.model.staticproxy;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/20
 */
public class TestMain {

    public static void main(String[] args) {
//        //1.有一个工厂店
//        Store store = new AppleStore();
//        //2.工厂店做事情----用户能看到的应该只有卖手机
//        Phone iPhone = store.selliPhone();

        //1.有一个代理店
        Store store = new ProxyStore();
        //2.代理店卖手机
        Phone iPhone = store.selliPhone();
        //3.用户使用
        iPhone.call();
        iPhone.play();
        iPhone.photo();
    }
}
