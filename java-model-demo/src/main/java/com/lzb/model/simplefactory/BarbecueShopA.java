package com.lzb.model.simplefactory;

/**
 * 该类为烧烤店A
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/19
 */
public class BarbecueShopA implements Barbecue{

    @Override
    public void saleKebab(){
        System.out.println("烧烤店A的烤串");
    }
}
