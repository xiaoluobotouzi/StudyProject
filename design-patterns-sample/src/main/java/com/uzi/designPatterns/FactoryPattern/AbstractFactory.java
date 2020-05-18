package com.uzi.designPatterns.FactoryPattern;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2020/5/18
 * ...
 */
public class AbstractFactory {

    public static void main(String[] args) {
        // 从工厂得到的产品都是兼容的
        CarsFactory carsFactory = new BMWFactory();
        carsFactory.createCarHub().carHub();
        carsFactory.createCarEngine().carEngine();

        carsFactory = new BenzFactory();
        carsFactory.createCarHub().carHub();
        carsFactory.createCarEngine().carEngine();
    }

}

// 具体的产品 汽车轮毂
interface CarHub{
    void carHub();
}

// 具体的产品 汽车发动机
interface CarEngine{
    void carEngine();
}

// 抽象工厂  汽车工厂
interface CarsFactory{
    CarHub createCarHub();
    CarEngine createCarEngine();
}

// BMW 产品族，创建自己的汽车轮毂
class BWMHub implements CarHub{

    @Override
    public void carHub() {
        System.out.println("宝马20寸轮毂");
    }
}

// BMW 产品族，创建自己的汽车发动机
class BWMEngine implements CarEngine{

    @Override
    public void carEngine() {
        System.out.println("宝马V8发动机");
    }
}

// BWM 产品族，具体工厂
class BMWFactory implements CarsFactory{

    @Override
    public CarHub createCarHub() {
        return new BWMHub();
    }

    @Override
    public CarEngine createCarEngine() {
        return new BWMEngine();
    }
}

// Benz 产品族，创建自己的汽车轮毂
class BenzHub implements CarHub{

    @Override
    public void carHub() {
        System.out.println("奔驰20寸轮毂");
    }
}

// Benz 产品族，创建自己的汽车发动机
class BenzEngine implements CarEngine{

    @Override
    public void carEngine() {
        System.out.println("奔驰V8发动机");
    }
}

// Benz 产品族，具体工厂
class BenzFactory implements CarsFactory{

    @Override
    public CarHub createCarHub() {
        return new BenzHub();
    }

    @Override
    public CarEngine createCarEngine() {
        return new BenzEngine();
    }
}