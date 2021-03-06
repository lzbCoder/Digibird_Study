package com.se.lambda.lambdatest;

/**
 * 子类调用与匿名内部类调用方法的比较
 *
 * @author lizhibin
 * @since 2021/5/12
 */
class Animals {
    public void eat() {
        System.out.println("动物吃东西");
    }

    public void sound() {
        System.out.println("动物会说话");
    }
}

class Dog extends Animals {
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }

    @Override
    public void sound() {
        System.out.println("汪汪");
    }
}

public class AnonymousInnerDemo {
    public static void main(String[] args) {

        //使用普通子类调用方法
        Dog dog = new Dog();
        dog.eat();

        //多态形式
        Animals animals = new Dog();
        animals.eat();

        //使用匿名内部类的方式来调用方法，即可以不用写Dog类
//        Animals animals = new Animals(){
//            @Override
//            public void eat(){
//                System.out.println("狗吃肉");
//            }
//            @Override
//            public void sound(){
//                System.out.println("汪汪");
//            }
//        };
//        animals.eat();
//        animals.sound();

    }
}
