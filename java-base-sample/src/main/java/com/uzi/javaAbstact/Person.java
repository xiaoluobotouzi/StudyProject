package com.uzi.javaAbstact;

/**
 * @ClassName: Person
 * @Description: TODO
 * @Author: uziJames
 * @Date 2020/3/8 17:24
 * ...
 */
public abstract class Person {

    abstract void work(String work);

    void eat(){
        System.out.print("吃饱饭才有力气工作! ");
    }
}
