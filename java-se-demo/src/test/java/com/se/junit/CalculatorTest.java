package com.se.junit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author: lzb
 * @version 1.2
 * @create: 2021-03-29 06:28
 **/
public class CalculatorTest {

    /**
      *@Description: 测试加法
      *@Param: []
      *@return: void
     **/
    @Test
    public void testAdd(){
        //创建Calculator对象
        Calculator c = new Calculator();
        //调用add方法测试
        int result = c.add(3,4);
        //使用断言：我期望值是7，实际测试值是result
        //若成功，则控制台亮绿色
//        Assert.assertEquals(7,result);
        //若失败，则控制台亮红色
        Assertions.assertEquals(3, result);

    }


    /**
      *@Description: 测试减法
      *@Param: []
      *@return: void
     **/
    @Test
    public void testSub(){

    }
}
