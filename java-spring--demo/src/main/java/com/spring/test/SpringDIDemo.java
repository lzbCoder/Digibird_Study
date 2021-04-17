package com.spring.test;

import com.spring.domain.Room;
import com.spring.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/16
 */
public class SpringDIDemo {
    /** 定义日志记录器，用于打印日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringIocDemo.class);

    /**
     *  该方法获取{@code BeanFactory}对象，使用该工厂对象读取
     *  {@code ApplicationContext.xml}文件，通过获取{@code bean}的
     *  {@code id}，来创建该{@code bean}的对象。
     */
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Room room = (Room) factory.getBean("room");
        LOGGER.info("Room对象为" + room);
    }
}
