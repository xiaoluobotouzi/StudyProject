package com.uzi.designPatterns.BuilderPattern;

/**
 * @Description: 建造者模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/5/18
 * ...
 */
public class BuilderSample {

    public static void main(String[] args) {
        BMWCarBuilder builder = new StandardConfigConcreteBMWCarBuilder(); // 标配1.5T
//        BMWCarBuilder builder = new HightConfigConcreteBMWCarBuilder(); // 高配2.0T
        Director director = new Director(builder);
        // 参数配置可选择
        BMWCar bmwCar = director.makeBMWCar("12", "XZ", true);
        System.out.println(bmwCar);
    }
}

// 产品类对象
class BMWCar {
    private String monitor; // 显示屏 8寸 12寸
    private String gearLever; // 变速杆 旋转 立杆
    private boolean chairHot = false; // 座椅加热 不是每个车都有
    private String engine; // 发动机
    // ...等等各种组件

    public BMWCar() {}

    public BMWCar(String monitor, String gearLever, boolean chairHot, String engine) {
        this.monitor = monitor;
        this.gearLever = gearLever;
        this.chairHot = chairHot;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "BMWCar{" +
                "monitor='" + monitor + '\'' +
                ", gearLever='" + gearLever + '\'' +
                ", chairHot=" + chairHot +
                ", engine=" + engine +
                '}';
    }
}

// 建造者抽象类，规范产品各个组成部分的建造
interface BMWCarBuilder{
    void builderMonitor(String monitor);
    void builderGearLever(String gearLever);
    void builderChairHot(boolean chairHot);
    BMWCar builder();
}

// 建造者，具体的构建类
class StandardConfigConcreteBMWCarBuilder implements BMWCarBuilder{

    // 建造者必须要持有产品对象的属性
    private String monitor;
    private String gearLever;
    private boolean chairHot;

    @Override
    public void builderMonitor(String monitor) {
        this.monitor = monitor;
    }

    @Override
    public void builderGearLever(String gearLever) {
        this.gearLever = gearLever;
    }

    @Override
    public void builderChairHot(boolean chairHot) {
        this.chairHot = chairHot;
    }

    @Override
    public BMWCar builder() {
        // 发动机，不支持客户端选，但创建这个产品对象不能少，客户端也不必知道
        String engine = "1.5T";
        return new BMWCar(monitor, gearLever, chairHot, engine);
    }
}

// 建造者，具体的构建类
class HightConfigConcreteBMWCarBuilder implements BMWCarBuilder{

    // 建造者必须要持有产品对象的属性
    private String monitor;
    private String gearLever;
    private boolean chairHot;

    @Override
    public void builderMonitor(String monitor) {
        this.monitor = monitor;
    }

    @Override
    public void builderGearLever(String gearLever) {
        this.gearLever = gearLever;
    }

    @Override
    public void builderChairHot(boolean chairHot) {
        this.chairHot = chairHot;
    }

    @Override
    public BMWCar builder() {
        // 发动机，不支持客户端选，但创建这个产品对象不能少，客户端也不必知道
        String engine = "2.0T";
        return new BMWCar(monitor, gearLever, chairHot, engine);
    }
}

// 调用者
class Director{
    private BMWCarBuilder bmwCarBuilder;

    public Director(BMWCarBuilder builder) {
        this.bmwCarBuilder = builder;
    }

    public BMWCar makeBMWCar(String monitor, String gearLever, boolean chairHot){
        bmwCarBuilder.builderMonitor(monitor);
        bmwCarBuilder.builderGearLever(gearLever);
        bmwCarBuilder.builderChairHot(chairHot);
        return bmwCarBuilder.builder();
    }
}

