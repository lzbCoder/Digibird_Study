package com.lzb.model.abstractfactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choise){
        if(choise.equalsIgnoreCase("PHONE")){
            return new PhoneFactory();
        }else if(choise.equalsIgnoreCase("TV")){
            return new TVFactory();
        }
        return null;
    }
}
