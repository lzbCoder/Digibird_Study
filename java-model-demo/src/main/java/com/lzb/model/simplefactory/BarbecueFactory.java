package com.lzb.model.simplefactory;

/**
 * 该类为烧烤店的工厂类，便于管理所有的烧烤店
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/19
 */
public class BarbecueFactory {

    /**
     * 该方法的作用根据用户给出的不同类型，来创建不同的对象给用户。
     *
     * @param type 类型
     * @return Barbecue 返回一个实现接口类型的对象
     */
    public static Barbecue getBarbecue(String type){
        if("烧烤店A".equals(type)){
            return new BarbecueShopA();
        }else if ("烧烤店B".equals(type)){
            return new BarbecueShopB();
        }else{
            return null;
        }
    }
}
