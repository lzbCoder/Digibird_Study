package com.se.lambda.consumer;

import java.util.function.Consumer;

/**
 * java.util.function.Consumer<T>接口则正好与Supplier接口相反，
 * 它不是生产一个数据，而是消费一个数据，其数据类型由泛型决定。
 * Consumer接口中包含抽象方法void accept(T t)，意为消费一个指定泛型的数据。
 * <p>
 * Consumer接口是一个消费型接口,泛型执行什么类型,就可以使用accept方法消费什么类型的数据
 * 至于具体怎么消费(使用),需要自定义(输出,计算....)
 *
 * @author lizhibin
 * @since 2021/5/12
 */
public class ConsumerDemo1Basic {

    /**
     * 该方法用来消费一个字符串型的一个变量
     *
     * @param name     字符串类型的姓名
     * @param consumer Consumer接口，泛型使用String
     */
    public static void consumerName(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

    public static void main(String[] args) {
        //调用method方法,传递字符串姓名,方法的另一个参数是Consumer接口,是一个函数式接口,所以可以传递Lambda表达式
        consumerName("张三", (name) -> {
            //消费方式一：打印输出
            System.out.println(name);

            //消费方式二：拼接字符串
            System.out.println(name + "1111");
        });
    }


}

