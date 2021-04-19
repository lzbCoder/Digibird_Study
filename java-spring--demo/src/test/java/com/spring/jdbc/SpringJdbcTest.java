package com.spring.jdbc;

import com.spring.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/15
 */

// 表示继承了SpringExtension类 Junit5
@ExtendWith(SpringExtension.class)
//加载spring容器
@ContextConfiguration(locations = { "classpath:ApplicationContext*.xml"})
public class SpringJdbcTest {

    /** 将对象jdbcTemplate自动注入 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *  该方法用于向student表中插入一条记录
     */
    @Test
    public void testInsert(){
        String insertSql = "insert into student values(?,?,?,?)";
        int insertCount = jdbcTemplate.update(insertSql,5,"张三5","男",24);
        Assertions.assertEquals(1,insertCount);
    }

    /**
     * 该方法用于删除student表中的一条记录
     */
    @Test
    public void testDelete(){
        String deleteSql = "delete from student where sid = ?";
        Integer deleteCount = jdbcTemplate.update(deleteSql,5);
        Assertions.assertNotNull(deleteCount);
    }

    /**
     * 该方法用于更新student表中的一条记录
     */
    @Test
    public void testUpdate(){
        String updateSql = "update student set sname = ? where sid = ?";
        Integer updateCount = jdbcTemplate.update(updateSql,"李四1",1);
        Assertions.assertNotNull(updateCount);
    }

    /**
     * 该方法用于查询表中的一条列数据
     */
    @Test
    public void testSelectToColumn(){
        String selectToColumnSql = "select sname from student where sid = ?";
        String result = jdbcTemplate.queryForObject(selectToColumnSql, String.class, 1);
        System.out.println(result);

    }

    /**
     * 该方法用于查询student表中的单行记录
     * 使用策略模式
     */
    @Test
    public void testSelectToRow(){
        String selectToRowSql = "select * from student where sid = ?";
        Student student1 =jdbcTemplate.queryForObject(selectToRowSql, ((resultSet, i) -> {
            Student student = new Student();
            student.setSid(resultSet.getInt("sid"));
            student.setSname(resultSet.getString("sname"));
            student.setSsex(resultSet.getString("ssex"));
            student.setSage(resultSet.getInt("sage"));
            return student;
        }),1);
        System.out.println(student1);
    }

    /**
     * 查询多行
     * 方式一：普通查询，返回的是List<Map<String,Object>>
     */
    @Test
    public void testSelectToRows(){
        String selectToRowsSql = "select * from student";
        List list = jdbcTemplate.queryForList(selectToRowsSql);
        System.out.println(list);
    }

    /**
     * 查询多行
     * 方式二：通过策略模式
     */
    @Test
    public void testSelectRowsToRowMapper(){
        String selectRowsToRowMapperSql = "select * from student";
        List<Student> students = jdbcTemplate.query(selectRowsToRowMapperSql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setSid(resultSet.getInt("sid"));
                student.setSname(resultSet.getString("sname"));
                student.setSsex(resultSet.getString("ssex"));
                student.setSage(resultSet.getInt("sage"));
                return student;
            }
        });
        for(Student student : students){
            System.out.println(student);
        }
    }

}
