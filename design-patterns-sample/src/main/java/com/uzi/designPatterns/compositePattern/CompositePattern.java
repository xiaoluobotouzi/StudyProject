package com.uzi.designPatterns.compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 组合模式 透明模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/5/21
 * ...
 */
public class CompositePattern {

    public static void main(String[] args) {

        CarComponent bmwX1 = new Car("bmwX1", 220600.56);
        CarComponent bmwX3 = new Car("bmwX3", 310800.99);
        CarComponent bmw = new CarBrand("BMW",2);
        bmw.addCar(bmwX1);
        bmw.addCar(bmwX3);

        CarComponent benzE300 = new Car("benzE300", 330800.28);
        CarComponent benz = new CarBrand("BenZ",2);
        benz.addCar(benzE300);

        CarComponent audi = new CarBrand("Audi",2);

        CarComponent allCar = new CarBrand("汽车大全",1);
        allCar.addCar(bmw);
        allCar.addCar(benz);
        allCar.addCar(audi);
        allCar.showInfo();


    }
}

// 场景案例就是 汽车是一个大范围，汽车有各种品牌，每个品牌下推出不同车型

/**
 * 定义最上层抽象根节点，把所有可能用到的方法都定义到最顶层的抽象类中，
 * 没有任何逻辑代码，为什么不用抽象方法呢？因为用了抽象方法，子类就必须实现，
 * 这样就体现不出子类的差异了。这样子类只需要重写差异方法覆盖父类的方法就行了。
 */
abstract class CarComponent{

    void addCar(CarComponent catalogCar){
        throw new UnsupportedOperationException("不支持上架操作");
    }

    void removeCar(CarComponent catalogCar){
        throw new UnsupportedOperationException("不支持下架操作");
    }

    String getName(CarComponent catalogCar){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    double getPrice(CarComponent catalogCar){
        throw new UnsupportedOperationException("不支持获取价格操作");
    }

    void showInfo(){
        throw new UnsupportedOperationException("不支持获取信息操作");
    }

}

// 定义树枝节点，也就是汽车品牌
class CarBrand extends CarComponent{
    private List<CarComponent> items = new ArrayList<>();

    private String name;
    private Integer level;

    public CarBrand(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    void addCar(CarComponent catalogCar) {
        items.add(catalogCar);
    }

    @Override
    void removeCar(CarComponent catalogCar) {
        items.remove(catalogCar);
    }

    @Override
    String getName(CarComponent catalogCar) {
        return this.name;
    }

    @Override
    void showInfo() {
        System.out.println(this.name);

        for (CarComponent carComponent : items){
            // 控制显示格式
            if(null != this.level){
                for (int i = 0; i < this.level; i++) {
                    System.out.print("  ");
                }
                for (int i = 0; i < this.level; i++) {
                    if(i == 0){
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            carComponent.showInfo();
        }
    }
}

// 定义叶子节点
class Car extends CarComponent{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    String getName(CarComponent catalogCar) {
        return this.name;
    }

    @Override
    double getPrice(CarComponent catalogCar) {
        return this.price;
    }

    @Override
    void showInfo() {
        System.out.println(String.format("%s 现报价 %s￥", this.name, this.price));
    }

}

