package com.uzi.designPatterns.singletonPattern;

/**
 * @Description: 单例设计模式 - 懒汉式（不安全的，安全的，双重校验的）
 * @Author: uziJames
 * @Date: 2020/5/14
 * ...
 */
public class LazySingleton {

    // 私有化构造函数
    private LazySingleton() {
    }

    // 静态成员变量
    private static LazySingleton singleton;

    // 懒加载，用到了才会创建，不安全
    public static LazySingleton getSingleton() {
        if (null != singleton) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    // 方法加锁，线程安全，效率低
    public static synchronized LazySingleton getSecuirtySingleton() {
        if (null == singleton) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    // 静态成员变量
    private volatile static LazySingleton singletonVolatile;

    // double check
    public static LazySingleton getDoubleCheckSingleton() {
        if (null == singletonVolatile) {
            synchronized (LazySingleton.class) {
                if (null == singletonVolatile) {
                    singletonVolatile = new LazySingleton();
                }
            }
        }
        return singletonVolatile;
    }

}
