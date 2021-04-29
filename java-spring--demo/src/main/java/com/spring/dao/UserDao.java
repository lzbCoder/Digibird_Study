package com.spring.dao;

import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/23
 */
public class UserDao {

    /** 将对象jdbcTemplate自动注入 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 通过名字来查找
     * @param name 用户名
     * @return user 查找出的user对象
     */
    public User selectOne(String name){
        String sql = "select * from user where name = ?";
        User user = jdbcTemplate.queryForObject(sql,User.class);
        return user;
    }

    /**
     * 存钱
     * @param user 用户对象
     */
    public void save(User user){
        String sql = "insert into user values(?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getMoney());
    }


}
