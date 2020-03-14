package com.uzi.designPrinciple.srp;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2019/8/30
 * ...
 */
public interface ISaleNonVip {

    // 非会员价
    Double nonVipPrice();

    // 非会员退货收取3元取件费
    void threeRMBReturnGoods();
}
