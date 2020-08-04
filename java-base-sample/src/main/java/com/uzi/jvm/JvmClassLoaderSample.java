package com.uzi.jvm;

import sun.misc.Launcher;

import java.net.URL;

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

        System.out.println("bootstrapLoader加载的类文件：");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }

        System.out.println();

        System.out.println("extClassloader加载的类文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载的类文件：");
        System.out.println(System.getProperty("java.class.path"));
    }
}
