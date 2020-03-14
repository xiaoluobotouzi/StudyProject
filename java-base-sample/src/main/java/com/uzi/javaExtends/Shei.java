package com.uzi.javaExtends;

public class Shei extends Person{

    public Shei(String name, String duty){
        setName(name);
        duty(duty);
    }

    @Override
    public void setName(String name) {
        name = "XXX";
        super.setName(name);
    }

    @Override
    public void duty(String duty) {
        System.out.println(getName() + " 不能告诉你在干什么");
    }
}