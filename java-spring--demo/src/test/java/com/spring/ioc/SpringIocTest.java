package com.spring.ioc;

import com.spring.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 该类对spring中的IoC进行测试
 *
 * @author lzb
 * @since 2021/4/14
 * @version 1.0
 **/
// 表示继承了SpringExtension类 Junit5
@ExtendWith(SpringExtension.class)
//加载spring容器
@ContextConfiguration(locations = { "classpath:ApplicationContext.xml"})
public class SpringIocTest {

    /** 定义日志记录器，用于打印日志 */
    private final Logger LOGGER = LoggerFactory.getLogger(SpringIocTest.class);

    /** 自动注入student对象 */
    @Autowired
    private Student student;

    /**
     * 该方法是通过使用原生的方式来创建实体类<code>Student</code>对象,
     * 没有使用Spring的IOC
     */
    @Test
    public void testStudentCreateByNative(){
        Student student = new Student();
        LOGGER.info("student对象为:" + student);
    }

    /**
     * 该方法是通过使用spring框架中的IoC方式来创建实体类
     * <code>Student</code>对象
     */
    @Test
    public void testStudentCreateByIoC(){
        LOGGER.info("Student对象" + student);
    }


}




