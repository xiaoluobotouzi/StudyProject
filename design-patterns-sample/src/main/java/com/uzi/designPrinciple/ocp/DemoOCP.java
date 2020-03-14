package com.uzi.designPrinciple.ocp;

/**
 * @Description: 开闭原则-demo
 * @Author: LIU.KL
 * @Date: 2019/8/25
 * ...
 */
public class DemoOCP {

    public static void main(String[] args) {
        TBD11();
        JD618();
    }

    public static void JD618() {

        HuaWeiDiscountPhone huaWeiDiscountPhone = new HuaWeiDiscountPhone(1, "Mate 20", 3888.00);

        Double originPrice = huaWeiDiscountPhone.getOriginPrice();
        System.out.println("华为手机原价 " + originPrice);

        Double price = huaWeiDiscountPhone.getPrice();
        System.out.println("华为手机618价 " + price);

    }

    public static void TBD11() {

        HuaWeiPhone huaWeiPhone = new HuaWeiPhone(2, "Nova 5", 2899.00);

        String model = huaWeiPhone.getModel();
        Double price = huaWeiPhone.getPrice();
        System.out.println(model + " 售价 " + price);

    }
}
