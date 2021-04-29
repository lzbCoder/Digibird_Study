package com.spring.transation;

import com.spring.domain.User;
import com.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/23
 */
// 表示继承了SpringExtension类 Junit5
@ExtendWith(SpringExtension.class)
//加载spring容器
@ContextConfiguration(locations = { "classpath:ApplicationContext*.xml"})
public class SpringTransationTest {



    @Test
    public void transferMoney(){

    }

}
