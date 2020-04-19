package com.uzi.javaGenericParadigm;

import java.util.*;

/**
 * @Description: 泛型示例
 * @Author: LIU.KL
 * @Date: 2020/4/16
 * ...
 */
public class GenericParadigmSample {

    public static void main(String[] args) {

        // 泛型示例
//        GenericParadigmListSample();


        // 泛型理解
//        List<String> ls = new ArrayList<String>(); // 1
//        List<Object> lo = ls; // 2

//        lo.add(new Object()); // 3
//        String s = ls.get(0); // 4: Attempts to assign an Object to a String!


        // 泛型 类型
//        List<String> stringArrayList = new ArrayList<>();
//        List<Integer> integerArrayList = new ArrayList<>();
//
//        Class classStringArrayList = stringArrayList.getClass();
//        Class classIntegerArrayList = integerArrayList.getClass();
//
//        if(classStringArrayList.equals(classIntegerArrayList)){
//            System.out.println("泛型测试，类型相同");
//        }


        // 加入泛型
//        Collection<?> c = new ArrayList<String>();
//        c.add(new Object()); // Compile time error

    }

    /**
     * 泛型类
     * @param <T>
     */
    public class ObjectTool<T> {
        private T obj;

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }
    }

    /**
     * 泛型方法
     */
    public static void genericMethods() {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<Object>();

        // T inferred to be Object
        fromArrayToCollection2(oa, co);

        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<String>();

        // T inferred to be String
        fromArrayToCollection2(sa, cs);

        // T inferred to be Object
        fromArrayToCollection2(sa, co);

        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];
        Collection<Number> cn = new ArrayList<Number>();

        // T inferred to be Number
        fromArrayToCollection2(ia, cn);

        // T inferred to be Number
        fromArrayToCollection2(fa, cn);

        // T inferred to be Number
        fromArrayToCollection2(na, cn);

        // T inferred to be Object
        fromArrayToCollection2(na, co);

        // compile-time error
//        fromArrayToCollection2(na, cs);

    }
    public static void fromArrayToCollection(Object[] a, Collection<?> c) {
        for (Object o : a) {
//            c.add(o); // compile-time error
        }
    }
    public static <T> void fromArrayToCollection2(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o); // Correct
        }
    }

    /**
     * 泛型的演变
     * @param c
     */
    public void printCollection(Collection c) {
        Iterator i = c.iterator();
        for (int j = 0; j < c.size(); j++) {
            System.out.println(i.next());
        }
    }
    public void printCollectionGenerics(Collection<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }
    public void printCollectionWildcards(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    /**
     * 一个小疑问例子？？？ List做了兼容吗？泛型接口不写<>可行？
     * @param args
     */
    public static void match(String[] args) {
        List<String> s = Arrays.asList("1","2","3");
        List<Integer> ss = Arrays.asList(11,22,33);
        test(s);
        test(ss);
    }
    public static void test(List list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    /**
     * 无泛型的集合示例
     */
    public static void GenericParadigmListSample() {
        // 元素类型为 Object 的集合，元素可以是任何类型。
        List arrayList = new ArrayList();
        arrayList.add("abc");
        arrayList.add(100);

        for(int i = 0; i< arrayList.size();i++){
            // Object 来接集合元素，没问题。
            Object o = arrayList.get(i);
            System.out.println(o);
            // Object 太通用了，操作甚是不方便，转成 String 或者 其他类型的数据来操作
            // 竟然报错了。。。
            String item = (String) arrayList.get(i);
            System.out.println(item);
        }
    }


}
