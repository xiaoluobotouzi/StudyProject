package com.uzi.designPrinciple.srp;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2019/8/30
 * ...
 */
public interface ISale {

    // 会员价
    Double vipPrice();

    // 非会员价
    Double nonVipPrice();

    // 会员免费退货
    void freeAdmissionReturnGoods();

    // 非会员退货收取3元取件费
    void threeRMBReturnGoods();

    // ...等等一些会员非会员的差别

}
