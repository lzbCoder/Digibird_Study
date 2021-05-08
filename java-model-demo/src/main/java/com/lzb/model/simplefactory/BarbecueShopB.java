package com.lzb.model.simplefactory;

import java.util.stream.Stream;

/**
 * 该类为烧烤店B
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/19
 */
public class BarbecueShopB implements Barbecue{

    @Override
    public void saleKebab(){
        System.out.println("烧烤店B的烤串");
    }
}
