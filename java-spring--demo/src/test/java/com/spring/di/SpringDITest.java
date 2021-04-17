package com.spring.di;

import com.spring.controller.StudentController;
import com.spring.domain.Room;
import com.spring.ioc.SpringIocTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 该类对spring中的DI进行测试
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/14
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext.xml"})
public class SpringDITest {

    /** 定义日志记录器，用于打印日志 */
    private final Logger LOGGER = LoggerFactory.getLogger(SpringIocTest.class);
    /** 自动注入room对象 */
    @Autowired
    private Room room;
    @Autowired
    private StudentController studentController;

    /**
     * 该方法是通过使用spring框架中的IoC方式来创建实体类
     * <code>Room</code>对象
     */
    @Test
    public void testRoomCreateByIoC(){
        LOGGER.info("Room对象:[{}]",room);
        Assertions.assertNotNull(room);
    }

    @Test
    public void testStudentControllerByIoc(){
        LOGGER.info("studentController:[{}]",studentController.toString());
        Assertions.assertNotNull(studentController);
    }



}
