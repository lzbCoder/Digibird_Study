package com.spring.controller;

import com.spring.service.StudentService;

/**
 * 该类为{@code student}的控制层
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/16
 */
public class StudentController {

    /** 服务层对象{@code service} */
    private StudentService service;

    //方式一 带参数的构造方法
    public StudentController(StudentService service) {
        System.out.println("controller的有参数构造方法 service属性被赋值");
        this.service = service;
    }
    //方式二 无参数构造方法+set方法
//    public StudentController() {
//        System.out.println("controller的无参数构造方法");
//    }
//    public void setService(StudentService service) {
//        System.out.println("set方法 service属性被创建了");
//        this.service = service;
//    }

    public void login(){
        System.out.println("controller层接收请求信息");
        //获取请求发送过来的信息
        //调用service去处理业务---->
        service.login();
        //根据service处理的结果 给予响应
        System.out.println("controller层给予响应");
    }

    @Override
    public String toString() {
        return "StudentController{" +
                "service=" + service +
                '}';
    }
}
