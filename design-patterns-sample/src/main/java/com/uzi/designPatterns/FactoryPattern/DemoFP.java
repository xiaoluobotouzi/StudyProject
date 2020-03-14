package com.uzi.designPatterns.FactoryPattern;

/**
 * @Description: 简单工厂模式 -demo
 * @Author: LIU.KL
 * @Date: 2019/10/23
 * ...
 */
public class DemoFP {

    public static void main(String[] args) {

        CarFactory carFactoryBmw = new BmwCarFactory();
        Car bmw = carFactoryBmw.createCar();
        bmw.get();

        CarFactory carFactoryBenZ = new BenZCarFactory();
        Car benz = carFactoryBenZ.createCar();
        benz.get();

    }
}
