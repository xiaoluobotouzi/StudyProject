package com.uzi.javaAbstact;

/**
 * @ClassName: TestAbst
 * @Description: TODO
 * @Author: uziJames
 * @Date 2020/3/8 17:26
 * ...
 */
public class TestAbst {

    public static void main(String[] args) {
        Person p = new Student();
        p.eat();
        p.work("听课");
        p = new Teacher();
        p.eat();
        p.work("讲课");

        TestAbst(new Student(), "s 听课");
        TestAbst(new Teacher(), "t 讲课");

    }

    public static void TestAbst(Person p, String work) {
        p.eat();
        p.work(work);
    }
}
