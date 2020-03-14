package com.uzi.javaPolymorphic;

/**
 * @ClassName: A
 * @Description: TODO
 * @Author: uziJamesi
 * @Date 2020/3/8 15:14
 * ...
 */
public class A {

    public String show(D obj){
        return ("A and D");
    }
    public String show(A obj){
        return ("A and A");
    }

}
