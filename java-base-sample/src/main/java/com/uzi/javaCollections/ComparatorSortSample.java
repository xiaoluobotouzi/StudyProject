package com.uzi.javaCollections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ClassName: ComparatorSortSample
 * @Description: 比较器排序示例
 * @Author: uziJames
 * @Date 2020/3/29 23:39
 * ...
 */
public class ComparatorSortSample {


    public static void main(String[] args) {
        anonymousInnerClass();

        ComparatorSort.comparatorSortClass();

    }

    /**
     * 实现 Comparator 重写 compare
     */
    public static class ComparatorSort implements Comparator<User> {
        @Override
        public int compare(User u1, User u2) {
            // 先判断姓名长度的大小
            int num = u1.getName().length() - u2.getName().length();
            // 姓名长度一致时，比较内容是否一致
            int num2 = num==0 ?u1.getName().compareTo(u2.getName()) :num;
            // 姓名内容一致时，比较年龄
            int num3 = num2==0 ?(u1.getAge() - u2.getAge()) :num2;
            return num3;
        }

        public static void comparatorSortClass(){
            TreeSet<User> treeSetUser = new TreeSet<>(new ComparatorSort());
            treeSetUser.add(new User("zhangsan", 22));
            treeSetUser.add(new User("lisi", 20));
            treeSetUser.add(new User("wangwu", 25));
            System.out.println(treeSetUser);
        }
    }

    /**
     * 通过匿名内部类实现
     */
    public static void anonymousInnerClass(){
        TreeSet<User> treeSetUser = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                // 先判断姓名长度的大小
                int num = u1.getName().length() - u2.getName().length();
                // 姓名长度一致时，比较内容是否一致
                int num2 = num==0 ?u1.getName().compareTo(u2.getName()) :num;
                // 姓名内容一致时，比较年龄
                int num3 = num2==0 ?(u1.getAge() - u2.getAge()) :num2;
                return num3;
            }
        });

        treeSetUser.add(new User("zhangsan", 22));
        treeSetUser.add(new User("lisi", 20));
        treeSetUser.add(new User("wangwu", 25));

        System.out.println(treeSetUser);
    }
}
