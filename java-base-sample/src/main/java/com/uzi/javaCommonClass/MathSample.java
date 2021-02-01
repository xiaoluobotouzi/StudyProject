package com.uzi.javaCommonClass;

import java.math.BigDecimal;

/**
 * @ClassName: MathSample
 * @Description: TODO
 * @Author: uziJames
 * @Date 2020/3/15 13:27
 * ...
 */
public class MathSample {

    public static void main(String[] args) {
//        mathUzi();

        bigDecimalUzi();
    }

    public static void bigDecimalUzi() {
        BigDecimal bigInt = new BigDecimal(1);
        BigDecimal bigDouble = new BigDecimal(0.1);
        BigDecimal bigString = new BigDecimal("0.1");
        System.out.println("bigInt = " + bigInt);
        System.out.println("bigDouble = " + bigDouble);
        System.out.println("bigString = " + bigString);
    }

    public static void mathUzi() {
        //随机数(取出来的是小于1的 double 型随机数字)
        System.out.println(Math.random());

        //向上取整(不管小数点后面是多少，直接进1)
        System.out.println(Math.ceil(11.01)); // 12.0
        System.out.println(Math.ceil(11.99)); // 12.0

        //向下取整(不管小数点后面是多少，直接舍去)
        System.out.println(Math.floor(11.01)); // 11.0
        System.out.println(Math.floor(11.99)); // 11.0

        //四舍五入(正常数学里的四舍五入)
        System.out.println(Math.round(11.51)); // 12
        System.out.println(Math.round(11.49)); // 11

        //获取圆周率
        System.out.println(Math.PI); // 3.141592653589793

        //绝对值(不管正负，得到的总是正数，0比较特殊，得到的就是0)
        System.out.println(Math.abs(-10.11)); // 10.11
        System.out.println(Math.abs(10.11)); // 10.11

        // 计算平方根
        System.out.println(Math.sqrt(16)); // 4.0

        //计算立方根
        System.out.println(Math.cbrt(8));  // 2.0

        //计算a的b次方
        System.out.println(Math.pow(3,2)); // 9.0

        //取出最大值
        System.out.println(Math.max(11.99, 12.0)); // 12.0

        //取出最小值
        System.out.println(Math.min(11.99, 12.0)); // 11.99
    }
}
