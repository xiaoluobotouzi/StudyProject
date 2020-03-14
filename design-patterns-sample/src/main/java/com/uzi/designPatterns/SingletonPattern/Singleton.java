package com.uzi.designPatterns.SingletonPattern;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2019/10/23
 * ...
 */
public class Singleton {

    // ====================================================饿汉式
    // 私有化构造函数
//    private Singleton(){}
//    // 类初始化时，就加载该对象。线程安全，调用效率高
//    private static Singleton singleton = new Singleton();
//    // 调用此方法，返回该对象
//    public static Singleton getInstance() {
//        return singleton;
//    }

    // ====================================================懒汉式
    // 私有化构造函数
//    private Singleton (){}
//    // 声明该对象，但不会初始化，用到时候才会去实例化它
//    private static Singleton singleton;
//    // 调用此方法，返回该对象
//    public static Singleton getSingleton() {
//        // 对象为空，去实例化。不为空，直接返回
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    // ====================================================安全の懒汉式
    // 私有化构造函数
//    private Singleton (){}
//    // 声明该对象，但不会初始化，用到时候才会去实例化它
//    private static Singleton singleton;
//    // 调用此方法，返回该对象
//    public static synchronized Singleton getSingleton() {
//        // 对象为空，去实例化。不为空，直接返回
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    // ====================================================双重验证锁
    // 私有化构造函数
//    private Singleton (){}
//    // 声明该对象，但不会初始化，用到时候才会去实例化它
//    private volatile static Singleton singleton;
//    // 调用此方法，返回该对象
//    public static Singleton getInstance() {
//        // 对象为空，去实例化。不为空，直接返回
//        if (singleton == null) {
//            // 加锁校验
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }

    // ====================================================登记式（静态内部类）
    // 私有化构造函数
    private Singleton (){}

    private static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }




}
