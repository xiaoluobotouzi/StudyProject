package com.uzi.jvm;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @ClassName: JvmClassLoaderSample
 * @Description: TODO
 * @Author: uziJamesi
 * @Date 2020/7/29 22:50
 * ...
 */
public class JvmClassLoaderSample {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(JvmClassLoaderSample.class.getClassLoader());

        System.out.println();

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println();


    }

}
