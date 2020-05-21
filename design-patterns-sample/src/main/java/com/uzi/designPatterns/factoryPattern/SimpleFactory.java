package com.uzi.designPatterns.factoryPattern;

/**
 * @Description: 简单工厂 - demo
 * @Author: LIU.KL
 * @Date: 2020/5/18
 * ...
 */
public class SimpleFactory {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        carFactory.getCar("BMW").getCar();
    }

}

// 汽车接口 具体的抽象角色，创建所有对象的父类，描述的是所有实例的公共接口
interface Car{

    void getCar();

}

// 宝马汽车 具体的实例对象
class BMWCar implements Car{

    @Override
    public void getCar() {
        System.out.println("your dream car is BMW");
    }
}

// 奔驰汽车 具体的实例对象
class BenzCar implements Car{

    @Override
    public void getCar() {
        System.out.println("your dream car is BenZ");
    }
}

// 工厂角色 简单工厂的核心，负责创建所有实例的内部逻辑，可被外界直接调用，创建具体对象
class CarFactory{

    public Car getCar(String dreamCar){
        if("BMW".equals(dreamCar)){
            // ... 逻辑代码
            return new BMWCar();
        }else if("BenZ".equals(dreamCar)){
            // ... 逻辑代码
            return new BenzCar();
        }
        return null;
    }

}

