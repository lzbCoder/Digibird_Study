package com.debug.basic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @program: Digibird_Study
 * @description: 强制步入(Force Step Info Alt + Shift + F7)：
 *                      进入官方类库方法，帮助我们学习和查看JDK源码，当然也可以进入
 *                      自定义方法内部。
 *               步出(Step Out Shift+F8)：
 *                      从方法内退出到方法调用处，调式的时候，有时候会跳入到自己不想
 *                      查看的方法体，这时时候使用步出。不论官方源码还是自定义方法，都可以。
 * @author: lzb
 * @create: 2021-03-28 11:48
 **/
public class DebugDemo3 {

    public static void main(String[] args) {
        System.out.println("begin...");
        operatorList();
        System.out.println("end...");
    }

    private static void operatorList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("zs1");
        list.add("zs2");
        list.add("zs3");
        list.add("zs4");
        //获取集合迭代器
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }
    }

}
