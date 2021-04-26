package com.uzi.javaPolymorphic;

/**
 * @ClassName: B
 * @Description: TODO
 * @Author: uziJames
 * @Date 2020/3/8 15:15
 * ...
 */
public class B extends A{

    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    }

}
