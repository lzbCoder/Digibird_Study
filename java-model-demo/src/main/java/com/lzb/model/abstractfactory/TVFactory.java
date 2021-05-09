package com.lzb.model.abstractfactory;

public class TVFactory implements AbstractFactory{

    @Override
    public Phone getPhone(String phoneType) {
        return null;
    }

    @Override
    public TV getTV(String tvType) {
        if(tvType == null){
            return null;
        }
        if(tvType.equalsIgnoreCase("SAMSUNG")){
            return new SamsungTV();
        }else if(tvType.equalsIgnoreCase("SONY")){
            return new SonyTV();
        }
        return null;
    }

}
