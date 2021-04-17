package com.se.lambda;

class Animals{
    public void eat(){
        System.out.println("动物吃东西");
    }
    public void sound(){
        System.out.println("动物会说话");
    }
}

//class Dog extends Animals{
//    @Override
//    public void eat(){
//        System.out.println("狗吃肉");
//    }
//    @Override
//    public void sound(){
//        System.out.println("汪汪");
//    }
//}

public class AnonymousInnerDemo {
    public static void main(String[] args) {
        //普通的方法调用
//        Animals animals = new Animals();
//        animals.eat();
//
//        //使用普通类继承来调用方法
//        Dog dog = new Dog();
//        dog.eat();

        //使用匿名内部类的方式来调用方法，即可以不用写Dog类
        Animals animals = new Animals(){
            @Override
            public void eat(){
                System.out.println("狗吃肉");
            }
            @Override
            public void sound(){
                System.out.println("汪汪");
            }
        };
        animals.eat();
        animals.sound();

    }
}
