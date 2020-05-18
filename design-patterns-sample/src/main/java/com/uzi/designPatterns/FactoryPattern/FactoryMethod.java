package com.uzi.designPatterns.FactoryPattern;

/**
 * @Description: 工厂方法 - demo
 * @Author: LIU.KL
 * @Date: 2020/5/18
 * ...
 */
public class FactoryMethod {

    public static void main(String[] args) {
        CarFactorys carFactorys = new BWMCarFactory();
        carFactorys.createCar().getCar();

        carFactorys = new BenzCarFactory();
        carFactorys.createCar().getCar();
    }

}

// 抽象工厂，造车的工厂
interface CarFactorys{
    Cars createCar();
}

// 具体工厂，各自产品有各自的工厂
class BWMCarFactory implements CarFactorys{

    @Override
    public BMWCars createCar() {
        return new BMWCars();
    }
}

// 具体工厂，各自产品有各自的工厂
class BenzCarFactory implements CarFactorys{

    @Override
    public BenzCars createCar() {
        return new BenzCars();
    }
}

// 抽象产品
interface Cars{
    void getCar();
}

// 具体产品
class BMWCars implements Cars{

    @Override
    public void getCar() {
        System.out.println("Get a One BMW Car");
    }
}

// 具体产品
class BenzCars implements Cars{

    @Override
    public void getCar() {
        System.out.println("Get a One Benz Car");
    }
}