package com.spring.domain;

/**
 * @author lzb
 * @version 1.0
 * @since 2021/4/16
 */
public class Room {

    //机房房间号 属性
    private String name;
    //机房中有一台电脑
    private Computer computer;

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", computer=" + computer +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Computer getComputer() {
        return computer;
    }
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
