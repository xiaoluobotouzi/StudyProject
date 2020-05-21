package com.uzi.designPatterns.singletonPattern;

/**
 * @Description: 单例设计模式 - 饿汉式
 * @Author: uziJamesi
 * @Date: 2020/5/14
 * ...
 */
public class HungrySingleton{

    // 私有化构造函数
    private HungrySingleton(){}

    // 静态成员变量，类加载时 实例化该对象
    private static HungrySingleton singleton = new HungrySingleton();

    // 全局访问点，提前实例化好的对象，调用该方法就返回当前对象
    public static HungrySingleton getSingleton(){
        return singleton;
    }

}