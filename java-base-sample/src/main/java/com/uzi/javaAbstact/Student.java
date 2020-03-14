package com.uzi.javaAbstact;

/**
 * @ClassName: Student
 * @Description: TODO
 * @Author: uziJamesi
 * @Date 2020/3/8 17:25
 * ...
 */
public class Student extends Person{
    @Override
    void work(String work) {
        System.out.println("学生类 " + work);
    }
}
