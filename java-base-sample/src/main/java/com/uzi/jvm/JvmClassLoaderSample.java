package com.uzi.jvm;

import sun.misc.Launcher;

import java.lang.reflect.Method;
import java.net.URL;

/**
 * @ClassName: JvmClassLoaderSample
 * @Description: 类加载器
 * @Author: uziJames
 * @Date 2020/7/29 22:50
 * ...
 */
public class JvmClassLoaderSample {

    public static void main(String[] args) throws Exception {

        // 类加载器职责
//        classLoader();

        // 自定义类加载器，不能重写 loadClass 还得去委托加载
//        customClassLoader();

        // 打破双亲委派机制，重写 loadClass 去加载 自己写的 java.lang.String
//        customClassLoaderString();



    }

    /**
     * 自定义类加载器
     *
     * @throws Exception
     */
    private static void customClassLoader() throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:/StudyIT/Jvm");
        Class clazz = myClassLoader.loadClass("Test");
        Object object = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("test", null);
        method.invoke(object, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

    /**
     * 自定义类加载器，打破双亲委派机制，加载自己写的 java.lang.String
     *
     * @throws Exception
     */
    private static void customClassLoaderString() throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:/StudyIT/Jvm");
        Class clazz = myClassLoader.loadClass("java.lang.String");
        Object object = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("test", null);
        method.invoke(object, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

    /**
     * 类加载器职责
     */
    private static void classLoader() {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(JvmClassLoaderSample.class.getClassLoader());

        System.out.println();

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println();

        Launcher launcher = new Launcher();
        System.out.println(launcher.getClassLoader());

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
