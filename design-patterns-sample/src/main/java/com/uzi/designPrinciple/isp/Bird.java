package com.uzi.designPrinciple.isp;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2019/9/19
 * ...
 */
public class Bird implements IAnimalEat,IAnimalFly{
    public void eat() {
        System.out.println("鸟吃食物");
    }

    public void fly() {
        System.out.println("鸟会飞");
    }
}
