package com.spring.domain;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/23
 */
public class User {

    private String name;
    private Integer age;
    private Float money;

    public User() {
    }

    public User(String name, Integer age, Float money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
