package com.uzi.designPrinciple.srp;

/**
 * @Description: 单一职责原则 demo
 * @Author: LIU.KL
 * @Date: 2019/8/29
 * ...
 */
public class DemoSRP {

//    public static void main(String[] args) {
//        Sale sale = new Sale();
//        sale.salePhone("Apple", 1888.00);
//        sale.salePhone("HuaWei", 1889.00);
//    }

//    public static void main(String[] args) {
//        SaleApplePhone saleApplePhone = new SaleApplePhone();
//        saleApplePhone.sale("Apple", 1888.00);
//
//        SaleHuaWeiPhone saleHuaWeiPhone = new SaleHuaWeiPhone();
//        saleHuaWeiPhone.sale("HuaWei", 1889.00);
//    }

//    public static void main(String[] args) {
//        Sale sale = new Sale();
//        sale.saleApplePhone("Apple 6S", 1888.00);
//        sale.saleHuaWeiPhone("HuaWei Pro ", 1889.00);
//    }

    public static void main(String[] args) {
        SaleApplePhone saleApplePhone = new SaleApplePhone();

        SaleApplePhone.SaleVip saleVip = saleApplePhone.new SaleVip();
        System.out.println(saleVip.vipPrice());
    }

}
