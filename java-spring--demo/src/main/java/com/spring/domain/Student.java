package com.spring.domain;

import java.io.Serializable;

/**
 * 该类为实体类
 *
 * @author lzb
 * @version 1.0
 */
public class Student implements Serializable {

    private Integer sid;
    private String sname;
    private String ssex;
    private Integer sage;

    public Student() {
    }

    public Student(Integer sid, String sname, String ssex, Integer sage) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public void setSage(String ssex) {
    }
}
