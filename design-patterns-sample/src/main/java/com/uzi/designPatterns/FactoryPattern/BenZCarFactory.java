package com.uzi.designPatterns.FactoryPattern;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2019/10/25
 * ...
 */
public class BenZCarFactory implements CarFactory{
    public Car createCar() {
        return new BenZCar();
    }
}
