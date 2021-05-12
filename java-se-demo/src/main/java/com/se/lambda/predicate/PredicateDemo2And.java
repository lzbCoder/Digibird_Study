package com.se.lambda.predicate;

import java.util.function.Predicate;

/**
 * @author lizhibin
 * @since 2021/5/12
 */

/*
    逻辑表达式:可以连接多个判断的条件
    &&:与运算符,有false则false
    ||:或运算符,有true则true
    !:非(取反)运算符,非真则假,非假则真

    需求:判断一个字符串,有两个判断的条件
        1.判断字符串的长度是否大于5
        2.判断字符串中是否包含a
    两个条件必须同时满足,我们就可以使用&&运算符连接两个条件

    Predicate接口中有一个方法and,表示并且关系,也可以用于连接两个判断条件
    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> this.test(t) && other.test(t);
    }
    方法内部的两个判断条件,也是使用&&运算符连接起来的
 */
public class PredicateDemo2And {

    /*
        定义一个方法,方法的参数,传递一个字符串
        传递两个Predicate接口
            一个用于判断字符串的长度是否大于5
            一个用于判断字符串中是否包含a
            两个条件必须同时满足
     */
    public static boolean checkString(String s, Predicate<String> predicate1, Predicate<String> predicate2) {
        //方式一：原生方法
        // return predicate1.test(s) && predicate2.test(s);
        //方式二：使用and方法
        return predicate1.and(predicate2).test(s);
    }

    public static void main(String[] args) {

        String str = "abcdegf";
        boolean b = checkString(str, (s) -> {
            //判断字符串的长度是否大于5
            return s.length() > 5;
        }, (s) -> {
            //判断字符串中是否包含a
            return s.contains("a");
        });
        System.out.println(b);
    }
}

