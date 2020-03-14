package com.uzi.javaPolymorphic;

/**
 * @ClassName: TestPoly
 * @Description: java 多态示例
 * @Author: uziJamesi
 * @Date 2020/3/8 15:16
 * ...
 */
public class TestPoly {
    public static void main(String[] args) {
        Person p = new Student();
        p.work("听课");
        p = new Teacher();
        p.work("讲课");

        TestPolys(new Student(),"s 听课");
        TestPolys(new Teacher(),"t 讲课");

    }

    public static void TestPolys(Person p, String work){
        p.work(work);
    }
}
