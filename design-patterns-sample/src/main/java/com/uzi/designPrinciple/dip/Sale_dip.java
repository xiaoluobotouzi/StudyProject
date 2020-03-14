package com.uzi.designPrinciple.dip;

/**
 * @Description: 销售类
 * @Author: LIU.KL
 * @Date: 2019/8/28
 * ...
 */
public class Sale_dip {

//    public void saleApplePhone(){
//        System.out.println("销售人员销售苹果手机");
//    }
//
//    public void saleHuaweiPhone(){
//        System.out.println("销售人员销售华为手机");
//    }



//    public void salePhone(ISale sale){
//        sale.sale();
//    }



//    private ISale sale;
//
//    public Sale(ISale sale){
//        this.sale = sale;
//    }
//
//    public void salePhone(){
//        sale.sale();
//    }


    private ISale_dip sale;

    public void setCource(ISale_dip sale){
        this.sale = sale;
    }

    public void salePhone(){
        sale.sale();
    }

}
