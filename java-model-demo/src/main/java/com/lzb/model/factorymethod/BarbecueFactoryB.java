package com.lzb.model.factorymethod;

public class BarbecueFactoryB implements BarbecueFactory{

    @Override
    public BarbecueShop getBarbecueShop() {
        return new BarbecueShopB();
    }
}
