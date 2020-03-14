package com.uzi.designPrinciple.isp;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2019/9/19
 * ...
 */
public class Dog implements IAnimalEat,IAnimalSwim{

    public void eat() {
        System.out.println("狗吃食物");
    }

    public void swim() {
        System.out.println("狗会游泳");
    }
}
