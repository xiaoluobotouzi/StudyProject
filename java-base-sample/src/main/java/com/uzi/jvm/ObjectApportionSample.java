package com.uzi.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @ClassName: ObjectApportionSample
 * @Description: 对象逃逸，栈上分配
 * @Author: kunLing
 * @Date 2021/3/2 8:57
 * ...
 */
public class ObjectApportionSample {

    public static User user = new User();
    public static SoftReference<User> user2 = new SoftReference<>(new User());
    public static WeakReference<User> user3 = new WeakReference<>(new User());


    /**
     * 栈上分配，标量替换
     * 代码调用了1亿次alloc()，如果是分配到堆上，大概需要1GB以上堆空间，如果堆空间小于该值，必然会触发GC
     *
     * 使用如下参数不会发生GC（JVM默认开启）
     * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
     *
     * 使用如下参数都会发生大量GC
     * -Xmx15m -Xms15m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
     * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("li.wu");
    }

    // 逃逸对象
    public User A(){
        User user = new User();
        user.setId(1);
        user.setName("li.san");
        // ... save db
        return user;
    }

    // 未逃逸对象，栈内分配
    public void B(){
        User user = new User();
        user.setId(2);
        user.setName("li.si");
        // ... save db
    }


    public static class User{
        private int id;
        private String name;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
