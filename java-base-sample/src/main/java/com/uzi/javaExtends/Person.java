package com.uzi.javaExtends;

public class Person {

    private String name;
    private String sex;
    private String age;

    public void duty(String duty){
        System.out.println(name + " " + duty);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}