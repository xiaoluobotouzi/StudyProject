package com.uzi.designPrinciple.isp;

/**
 * @Description: 鸟实现动物接口
 * @Author: LIU.KL
 * @Date: 2019/9/19
 * ...
 */
public class BirdImpl implements IAnimal{

    public void eat() {
        System.out.println("鸟吃食物");
    }

    public void fly() {
        System.out.println("鸟会飞");
    }

    public void swim() {
        System.out.println("鸟不能游泳");
    }
}
