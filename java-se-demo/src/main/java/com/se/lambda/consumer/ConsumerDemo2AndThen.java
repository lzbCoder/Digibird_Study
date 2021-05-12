package com.se.lambda.consumer;

import java.util.function.Consumer;

/**
 * 练习Consumer接口的默认方法andThen
 * <p>
 * 作用:需要两个Consumer接口,可以把两个Consumer接口组合到一起,在对数据进行消费
 * 例如:
 * Consumer<String> con1
 * Consumer<String> con2
 * String s = "hello";
 * con1.accept(s);
 * con2.accept(s);
 * 连接两个Consumer接口  再进行消费
 * con1.andThen(con2).accept(s); 谁写前边谁先消费
 *
 * @author lizhibin
 * @since 2021/5/12
 */
public class ConsumerDemo2AndThen {

    //定义一个方法,方法的参数传递一个字符串和两个Consumer接口,Consumer接口的泛型使用字符串
    public static void stringByDoubleConsumer(String str, Consumer<String> consumer1, Consumer<String> consumer2) {
        //方式一：不使用andThen时
        consumer1.accept(str);
        consumer2.accept(str);

        //方式二：使用andThen时
        consumer1.andThen(consumer2).accept(str);
    }

    public static void main(String[] args) {
        stringByDoubleConsumer("abc",
                               //消费方式:把字符串转换为大写输出
                               (s) -> System.out.println(s.toUpperCase()),
                               //消费方式:把字符串转换为小写输出
                               (s) -> System.out.println(s.toLowerCase()));
    }


}

