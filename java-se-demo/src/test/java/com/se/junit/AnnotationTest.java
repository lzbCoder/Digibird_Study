package com.se.junit;


import org.junit.jupiter.api.*;

/**
 * @program: Digitized_Study
 * @description: 测试单元测试中的方法注解
 * @author: lzb
 * @create: 2021-03-29 07:10
 */
public class AnnotationTest {

    /**
     * 初始化方法：
     *   用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @BeforeEach
    public void init(){
        System.out.println("init...");
    }

    /**
     * 释放资源方法：
     *   在所有测试方法执行完之后，都会执行该方法
     */
    @AfterEach
    public void after(){
        System.out.println("after...");
    }

    /**
     * 在所有测试方法执行之前执行，只执行一次
     */
    @BeforeAll
    public static void testBefore(){
        System.out.println("static before...");
    }

    /**
     * 在所有测试方法执行之后执行，只执行一次
     */
    @AfterAll
    public static void testAfter(){
        System.out.println("static after...");
    }

    /**
     * 普通测试方法
     */
    @Test
    public void testAdd(){
        System.out.println("testAdd...");
    }

    @Test
    public void testSub(){
        System.out.println("testSub...");
    }

}
