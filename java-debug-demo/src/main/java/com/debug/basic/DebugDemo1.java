package com.debug.basic;

/**
 * @program: Digibird_Study
 * @description: 调式面板中左侧第一个按钮：show Execution Point(Alt+10)
 *               作用：当查看各种类的关系时，想要返回当前程序执行到哪里？
 *               点击该按钮，可以快速跳转到当前代码执行的位置。
 *               即：如果你的光标在其他行或其他页面，点击这个按钮可跳转到当前代码
 *                  执行的行
 * @author: lzb
 * @create: 2021-03-28 11:26
 **/
public class DebugDemo1 {

    public static void main(String[] args) {
        int num = 1;
        System.out.println("num=" + num);
        num ++;
        System.out.println("num=" + num);
        num ++;
        System.out.println("num=" + num);
        num ++;
        System.out.println("num=" + num);
        num ++;
        System.out.println("num=" + num);
        num ++;

    }
}
