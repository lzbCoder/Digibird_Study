package com.lzb.model.factorymethod;

/**
 * 用来生产烧烤店A的产品
 */
public class BarbecueFactoryA implements BarbecueFactory{

    @Override
    public BarbecueShop getBarbecueShop() {
        return new BarbecueShopA();
    }
}
