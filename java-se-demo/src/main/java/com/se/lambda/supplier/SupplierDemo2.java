package com.se.lambda.supplier;

import java.util.function.Supplier;

/**
 * 练习：求数组元素最大值
 * 使用Supplier接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。
 * 提示：接口的泛型请使用java.lang.Integer类。
 *
 * @author lizhibin
 * @since 2021/5/12
 */
public class SupplierDemo2 {


    public static Integer getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        //定义一个数组
        int[] array = new int[]{1, 2, 3, 4};
        int maxValue = getMax(() -> {
            int max = array[0];
            for (int i : array) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println("数组中最大值为：" + maxValue);
    }

}

