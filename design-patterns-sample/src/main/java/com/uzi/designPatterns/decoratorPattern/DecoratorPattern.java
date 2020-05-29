package com.uzi.designPatterns.decoratorPattern;

/**
 * @Description: 装饰器模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/5/28
 * ...
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        Component component = new ConcreteDecoratorA(new ConcreteDecoratorB(new ConcreteComponent()));
        component.operation();
    }
}

// 抽象组件
interface Component{
    void operation();
}

// 具体组件 也是被装饰对象
class ConcreteComponent implements Component{

    @Override
    public void operation() {
        // 相机拍照功能
        System.out.println("拍照");
    }
}

// 抽象装饰类
// 如果系统中的装饰逻辑单一，不需要实现许多装饰器，可以省略该类，直接实现一个具体装饰器 ConcreteDecorator 即可
abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component){
        this.component = component;
    }
}

// 具体的装饰类，Decorator 的具体实现类，扩展了 Component 对象的一种功能
class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("美颜瘦脸");
        // 原功能不能丢
        component.operation();
    }
}

// 具体的装饰器，Decorator 的具体实现类，扩展了 Component 对象的一种功能
class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜");
        component.operation();
    }
}