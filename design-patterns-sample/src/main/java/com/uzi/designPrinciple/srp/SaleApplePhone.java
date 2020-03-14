package com.uzi.designPrinciple.srp;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2019/8/30
 * ...
 */
public class SaleApplePhone {

//    public void sale(String phone, Double price){
//        System.out.println(phone + " 销售价：" + price);
//    }

    public Double price = 1888.00;

    class SaleVip implements ISaleVip{

        public Double vipPrice() {
            return price * 0.75;
        }

        public void freeAdmissionReturnGoods() {
            // 免退货费
        }
    }

    class SaleNonVip implements ISaleNonVip{

        public Double nonVipPrice() {
            return price;
        }

        public void threeRMBReturnGoods() {
            // 收取3元退货费
        }
    }
}
