package com.lzb.model.abstractfactory;

/**
 * 抽象工厂类：既生产手机，也生产电视
 */
public interface AbstractFactory {

    Phone getPhone(String phoneType);
    TV getTV(String tvType);
}
