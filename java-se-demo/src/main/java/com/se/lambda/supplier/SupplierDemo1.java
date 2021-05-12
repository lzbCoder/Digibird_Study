package com.se.lambda.supplier;

import java.util.function.Supplier;

/**
 * 常用的函数式接口Supplier
 * <p>
 * java.util.function.Supplier<T> 仅包含一个无参的方法：T get()。用来获取一个泛型参数指定类型的对象数据。
 * Supplier<T>接口被称之为生产型接口,指定接口的泛型是什么类型,那么接口中的get方法就会生产什么类型的数据
 *
 * @author lizhibin
 * @since 2021/5/12
 */
public class SupplierDemo1 {

    public static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {

        //使用lambda表达式方式一
        String str1 = getString(() -> {
            return "111";
        });
        System.out.println(str1);

        //使用lambda表达式方式二：当只有一个表达式返回语句时，lambda会自动返回
        String str2 = getString(() -> "222");
        System.out.println(str2);
    }
}

