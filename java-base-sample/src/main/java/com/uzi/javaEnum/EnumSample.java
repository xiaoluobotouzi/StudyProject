package com.uzi.javaEnum;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @Description: 枚举类示例
 * @Author: LIU.KL
 * @Date: 2020/4/20
 * ...
 */
public class EnumSample {

    public static void main(String[] args) {

        // 001
//        enumCarsSample();
//        System.out.println("constant car is" + ConstantSample.CARS_BMW);


        // 002
//        CarsEnum[] values = CarsEnum.values();
//        System.out.println(Arrays.asList(values));
//
//        CarsEnum test = CarsEnum.valueOf("BMW");
//        System.out.println(test);


        // 003
//        String carName = "ASD";
//        switch (carName){
//            case CarsEnum.BMW.toString():
//                System.out.println("BMW 来了");
//                break;
//            case CarsEnum.Audi.toString():
//                System.out.println("Audi 来了");
//                break;
//            case CarsEnum.BenZ.toString():
//                System.out.println("BenZ 来了");
//                break;
//            default:
//                System.out.println("啥也不是");
//                break;
//        }

        enumSetSample();
    }

    public static void enumSetSample() {
        // 创建一个包含 CarsEnum（枚举类）里所有枚举值的EnumSet集合
        EnumSet e1 = EnumSet.allOf(CarsEnum.class);
        System.out.println(e1);

        // 创建一个空的EnumSet
        EnumSet e2 = EnumSet.noneOf(CarsEnum.class);
        System.out.println(e2);

        // 空EnumSet集合中add()枚举元素
        e2.add(CarsEnum.BenZ);
        e2.add(CarsEnum.BMW);
        System.out.println(e2);

        // 以指定枚举值创建EnumSet集合
        EnumSet e3 = EnumSet.of(CarsEnum.Audi,CarsEnum.BenZ);
        System.out.println(e3);

        // 创建一个包含从from枚举值到to枚举值范围内所有枚举值的EnumSet集合。
        EnumSet e4 = EnumSet.range(CarsEnum.BMW,CarsEnum.BMWX5);
        System.out.println(e4);

        // 创建一个其元素类型与指定EnumSet里元素类型相同的EnumSet集合，
        // 新EnumSet集合包含原EnumSet集合所不包含的枚举值
        EnumSet e5 = EnumSet.complementOf(e4);
        System.out.println(e5);
    }

    public static void enumCarsSample() {
        CarsEnum bmw = CarsEnum.BMW;
        System.out.println("Car is " + bmw);
    }

}
