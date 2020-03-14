package com.uzi.jxls;

import java.util.Date;

/**
 * @Description: student model
 * @Author: LIU.KL
 * ...
 */
public class StudentBean {

    private String name;
    private int age;
    private Date registerTime;
    private String claxx;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getClaxx() {
        return claxx;
    }

    public void setClaxx(String claxx) {
        this.claxx = claxx;
    }
}
