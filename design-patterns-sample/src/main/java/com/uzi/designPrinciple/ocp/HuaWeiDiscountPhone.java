package com.uzi.designPrinciple.ocp;

/**
 * @Description: 华为手机优惠类
 * @Author: LIU.KL
 * @Date: 2019/8/25
 * ...
 */
public class HuaWeiDiscountPhone extends HuaWeiPhone {

    public HuaWeiDiscountPhone(Integer id, String model, Double price) {
        super(id, model, price);
    }

    // 手机原价
    public Double getOriginPrice(){
        return super.getPrice();
    }

    // 手机优惠价 88折
    public Double getPrice(){
        return super.getPrice() * 0.88;
    }

    // 手机折扣价 88折
    public Double getDiscountPrice(){
        return super.getPrice() * 0.88;
    }
}
