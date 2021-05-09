package com.lzb.model.factorymethod;

/**
 * 该工厂是个抽象工厂，用来给具体工厂做统一规则
 */
public interface BarbecueFactory {

    BarbecueShop getBarbecueShop();
}
