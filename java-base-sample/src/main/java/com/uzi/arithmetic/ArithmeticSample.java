package com.uzi.arithmetic;

/**
 * @ClassName: ArithmeticSample
 * @Description: 算法示例
 * @Author: kunLing
 * @Date 2021/3/18 8:48
 * ...
 */
public class ArithmeticSample {

    public static void main(String[] args) {
        sample1(4);
    }

    /**
     * 题目：写出以下算法
     *   1-2+3-4+5-6····N
     */
    private static void sample1(int n){
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if(i / 2 == 0){
                j = -i;
            }else{
                j = +i;
            }
        }
        System.out.println(j);
    }
}
