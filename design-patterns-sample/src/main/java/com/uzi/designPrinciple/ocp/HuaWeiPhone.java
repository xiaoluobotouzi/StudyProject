package com.uzi.designPrinciple.ocp;

/**
 * @Description: 华为手机实现类
 * @Author: LIU.KL
 * @Date: 2019/8/25
 * ...
 */
public class HuaWeiPhone implements IMobilePhone{

    private Integer id;
    private String model;
    private Double price;

    public HuaWeiPhone(Integer id, String model, Double price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public Integer getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public Double getPrice() {
        return this.price;
    }
}
