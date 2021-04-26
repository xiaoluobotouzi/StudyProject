package com.uzi.jvm;

/**
 * @ClassName: JvmMemoryModel
 * @Description: JVM内存模型
 * @Author: uziJames
 * @Date 2021/1/24 16:58
 * ...
 */
public class JvmMemoryModel {

    public static void main(String[] args) {
        System.out.print("-Xmx = ");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");

        System.out.print("Free Mem = ");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");

        System.out.print("Total Mem = ");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
    }
}
