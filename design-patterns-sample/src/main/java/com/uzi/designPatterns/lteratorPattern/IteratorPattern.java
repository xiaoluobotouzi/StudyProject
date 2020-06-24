package com.uzi.designPatterns.lteratorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 迭代器模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/6/22
 * ...
 */
public class IteratorPattern {

    public static void main(String[] args) {
        Element e1 = new Element("java");
        Element e2 = new Element("ai");
        Element e3 = new Element("python");
        Element e4 = new Element("vue");

        Aggregate ca = new ConcreteAggregate();
        ca.add(e1);
        ca.add(e2);
        ca.add(e3);
        ca.add(e4);
        iteratorList(ca);

    }

    public static void iteratorList(Aggregate aggregate){
        Iterator<Element> iterator = aggregate.iterator();
        while (iterator.hasNext()){
            Element element = iterator.next();
            System.out.println(" > you like " + element.getName());
        }
    }
}

// 自定义抽象迭代器
interface Iterator<E>{

    E next();

    boolean hasNext();

}

class ConcreteIterator<E> implements Iterator<E>{

    List<E> list;
    int cursor;
    E element;

    public ConcreteIterator(List list){
        this.list = list;
    }

    @Override
    public E next() {
        System.out.print("当前位置索引：" + cursor);
        element = list.get(cursor);
        cursor ++;
        return element;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }
}

// 集合元素
class Element{

    private String name;

    public Element(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

// 集合容器接口
interface Aggregate{
    void add(Element e);
    void remove(Element e);
    Iterator<Element> iterator();
}

// 具体的集合容器
class ConcreteAggregate implements Aggregate{

    private List list;

    public ConcreteAggregate(){
        this.list = new ArrayList();
    }

    @Override
    public void add(Element e) {
        list.add(e);
    }

    @Override
    public void remove(Element e) {
        list.remove(e);
    }

    @Override
    public Iterator<Element> iterator() {
        return new ConcreteIterator(list);
    }
}