package com.lzb.model.abstractfactory;

public class PhoneFactory implements AbstractFactory{
    @Override
    public Phone getPhone(String phoneType) {
        if(phoneType == null){
            return null;
        }
        if(phoneType.equalsIgnoreCase("MI")){
            return new MiPhone();
        }else if(phoneType.equalsIgnoreCase("HUAWEI")){
            return new HuaWeiPhone();
        }
        return null;
    }

    @Override
    public TV getTV(String tvType) {
        return null;
    }
}
