package com.spring.service;
import com.spring.dao.StudentDao;

/**
 * 该类为{@code student}的服务层
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/16
 */
public class StudentService {

    private StudentDao dao;

    //方式一 带参数的构造方法
    public StudentService(StudentDao dao) {
        System.out.println("service的有参数构造方法 dao属性被赋值");
        this.dao = dao;
    }
    //方式二 无参数构造方法+set方法
//    public StudentService() {
//        System.out.println("service的无参数构造方法");
//    }
//    public void setDao(StudentDao dao) {
//        System.out.println("set方法 dao属性被创建了");
//        this.dao = dao;
//    }

    public void login(){
        //1.方法应该有参数  Controller传递给我的
        System.out.println("service层接收请求发来的信息");
        //2.做一些业务处理  判断   dao调用查询方法----->
        dao.selectOne();
        //3.将判断的结果返回
        System.out.println("service层处理业务并返回");
    }

    @Override
    public String toString() {
        return "StudentService{" +
                "dao=" + dao +
                '}';
    }


}
