package com.uzi.javaEnum;

import java.util.Arrays;

/**
 * @Description: 枚举类示例
 * @Author: LIU.KL
 * @Date: 2020/4/20
 * ...
 */
public class EnumSample {

    public static void main(String[] args) {

//        enumCarsSample();
//        System.out.println("constant car is" + ConstantSample.CARS_BMW);

        CarsEnum[] values = CarsEnum.values();
        System.out.println(Arrays.asList(values));

        CarsEnum test = CarsEnum.valueOf("BMW");
        System.out.println(test);



    }

    public static void enumCarsSample() {
        CarsEnum bmw = CarsEnum.BMW;
        System.out.println("Car is " + bmw);
    }

}
