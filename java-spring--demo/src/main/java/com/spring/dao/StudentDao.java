package com.spring.dao;

import com.spring.domain.Student;

/**
 * 该类为{@code student}的持久层
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/16
 */
public class StudentDao {

//    public StudentDao(){
//        System.out.println("dao的无参数构造方法");
//    }

    public Student selectOne(){
        //1.方法应该有参数，service层传递过来的
        System.out.println("dao层接收service层传递的信息");
        //2.自己写一条Sql语句
        System.out.println("执行数据库操作");
        //3.调用SqlSession做事就可以了
        System.out.println("将查询的结果返回");
        return null;
    }
}

