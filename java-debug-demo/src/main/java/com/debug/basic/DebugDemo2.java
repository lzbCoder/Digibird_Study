package com.debug.basic;

/**
 * @program: Digibird_Study
 * @description: 步过(Step Over F8)和步入(Step Into F7)调试的使用
 *               步过调试：步过，一行一行的往下走，如果这一行上有方法则不会进入，
 *                       常用于调试过程中不想进入调用的方法体的情况。
 *               步入调试：步入，一行一行的往下走，如果这一行上有方法，则进入方法
 *                        内部，一般用于进入自定义方法内，不会进入官方类库的方法。
 * @author: lzb
 * @create: 2021-03-28 11:33
 **/
public class DebugDemo2 {

    public static void main(String[] args) {
        int a1 = add(1,2);
        System.out.println(a1);
        int a2 = add(2,3);
        System.out.println(a1 + a2);
        int result = a1 + a2;
        System.out.println(result);
    }

    private static int add(int a, int b){
        int result = a + b;
        return result;
    }


}
