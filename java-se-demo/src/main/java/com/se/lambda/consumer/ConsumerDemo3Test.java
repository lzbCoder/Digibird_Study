package com.se.lambda.consumer;

import java.util.function.Consumer;

/**
 * 练习:
 * 字符串数组当中存有多条信息，请按照格式“姓名：XX。性别：XX。”的格式将信息打印出来。
 * 要求将打印姓名的动作作为第一个Consumer接口的Lambda实例，
 * 将打印性别的动作作为第二个Consumer接口的Lambda实例，
 * 将两个Consumer接口按照顺序“拼接”到一起。
 *
 * @author lizhibin
 * @since 2021/5/12
 */
public class ConsumerDemo3Test {

    //定义一个方法,参数传递String类型的数组和两个Consumer接口,泛型使用String
    public static void printInfo(String str[], Consumer<String> consumer1, Consumer<String> consumer2) {
        for (String message : str) {
            consumer1.andThen(consumer2).accept(message);
        }
    }

    public static void main(String[] args) {
        //定义一个字符串类型的数组
        String[] arr = {"张三,女", "李四,女", "王五,男"};

        //调用printInfo方法,传递一个字符串数组,和两个Lambda表达式
        printInfo(arr, (message) -> {
            //消费方式:对message进行切割,获取姓名,按照指定的格式输出
            String name = message.split(",")[0];
            System.out.println("姓名：" + name);
        }, (message) -> {
            //消费方式:对message进行切割,获取性别,按照指定的格式输出
            String age = message.split(",")[1];
            System.out.println("性别：" + age);
        });
    }

}

