package com.uzi.designPatterns.templateMethodPattern;

/**
 * @ClassName: TemplateMethodPattern
 * @Description: 模板方法模式  -demo
 * @Author: uziJamesi
 * @Date 2020/6/4 23:00
 * ...
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        AbstractClass ac = new SubClassA();
        ac.operation();

        ac = new SubClassB();
        ac.operation();
    }
}

// 抽象模板 定义算法骨架或流程
abstract class AbstractClass{
    public void operation(){
        System.out.println("必执行的算法或流程");
        templateMethod();
    }
    abstract protected void templateMethod();
}

// 具体子类实现
class SubClassA extends AbstractClass{
    @Override
    protected void templateMethod() {
        System.out.println("executed A ...");
    }
}
class SubClassB extends AbstractClass{
    @Override
    protected void templateMethod() {
        System.out.println("executed B ...");
    }
}

