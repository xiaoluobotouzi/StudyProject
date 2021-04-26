package com.uzi.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName: JolSample
 * @Description: 对象大小
 *
 * @Author: kunLing
 * @Date 2021/2/26 13:47
 * ...
 */
public class JolSample {

    public static void main(String[] args) {
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());

        System.out.println();

        ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(layout1.toPrintable());

        System.out.println();

        ClassLayout layout2 = ClassLayout.parseInstance(new A());
        System.out.println(layout2.toPrintable());

    }

    public  static class A {
        // 8B mark word 26  
        // 4B Class Pointer 如果关闭压缩 -XX:-UseCompressedClassPointers 或 -XX:-UseCompressedOops，则占用8B

        // 4B
        int id;

        // 4B 如果关闭压缩 -XX:-UseCompressedOops，则占用8B
        String name;

        // 1B
        byte b;

        // 4B 如果关闭压缩 -XX:-UseCompressedOops，则占用8B
        Object o;
    }
}
