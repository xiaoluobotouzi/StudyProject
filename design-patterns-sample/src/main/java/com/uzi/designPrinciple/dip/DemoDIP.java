package com.uzi.designPrinciple.dip;

/**
 * @Description: 依赖倒置原则-demo
 * @Author: LIU.KL
 * @Date: 2019/8/28
 * ...
 */
public class DemoDIP {

    public static void main(String[] args) {
        sale4();
    }

//    public static void sale1(){
//        Sale sale = new Sale();
//        sale.saleApplePhone();
//        sale.saleHuaweiPhone();
//    }
//
//    public static void sale2(){
//        Sale sale = new Sale();
//        sale.salePhone(new SaleHuaWeiPhone());
//        sale.salePhone(new SaleApplePhone());
//    }

//    public static void sale3(){
//        Sale sale = new Sale(new SaleHuaWeiPhone());
//        sale.salePhone();
//    }

    public static void sale4(){
        Sale_dip sale = new Sale_dip();
        sale.setCource(new SaleHuaWeiPhone_dip());
        sale.salePhone();

        sale.setCource(new SaleApplePhone_dip());
        sale.salePhone();

    }

}
