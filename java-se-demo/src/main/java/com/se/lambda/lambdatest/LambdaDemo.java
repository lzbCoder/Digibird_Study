package com.se.lambda.lambdatest;

/**
 * 匿名内部类与lambda表达式的比较
 *
 * @author lizhibin
 * @since 2021/5/12
 */
public class LambdaDemo {

    public static void main(String[] args) {

        //使用匿名内部类
        MathOperation mathOperation = new MathOperation(){
            @Override
            public void outMessage(String mes){
                System.out.println("hello"+mes);
            }
        };
        mathOperation.outMessage("world");


        //使用Lambda表达式
        MathOperation mo = (message) ->
                System.out.println("hello"+message);
        mo.outMessage("world");


        // 匿名内部类
//        Runnable r1 = new Runnable(){
//            @Override
//            public void run(){
//                System.out.println("Hello World!");
//            }
//        };
//
//        // Lambda表达式
//        Runnable r2 = () -> System.out.println("Hello World!");

        Runnable r1 = () -> System.out.println("Hello Lambda");
        MyRunnable r2 = () -> System.out.println("Hello Lambda");

    }

    //函数式接口
    interface MathOperation{
        void  outMessage(String mes);
    }

    //自定义Runnable接口
    interface MyRunnable{
        void run();
    }

}
