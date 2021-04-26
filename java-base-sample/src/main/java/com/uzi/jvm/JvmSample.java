package com.uzi.jvm;

/**
 * @ClassName: JvmSample
 * @Description: 类加载
 * @Author: uziJames
 * @Date 2020/7/8 22:18
 * ...
 */
public class JvmSample {

    static {
        System.out.println(">>>加载JvmSample");
    }

    public static void main(String[] args) {
        A a = new A();
        // B 是不会被加载的。只有在 new 的时候，才会被加载
        B b1 = null;
    }
}

class A {
    static {
        System.out.println(">>>加载 A");
    }

    public A() {
        System.out.println(">>>初始化 A");
    }
}

class B {
    static {
        System.out.println(">>>加载 B");
    }

    public B() {
        System.out.println(">>>初始化 B");
    }
}
