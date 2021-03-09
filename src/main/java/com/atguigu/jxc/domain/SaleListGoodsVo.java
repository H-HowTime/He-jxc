package com.atguigu.jxc.domain;

import lombok.Data;

/**
 * @author 刘兴龙
 * @create 2021-03-08 15:46
 */
@Data
public class SaleListGoodsVO {

    private Integer saleListId;
    private String saleNumber;
    private double amountPaid;
    private double amountPayable;
    private String saleDate;
    private Integer state;
    private String remarks;
    private Integer customerId;
    private Integer userId;

    private String customerName;
//    private String trueName;

    private Integer saleListGoodsId;
    private Integer goodsId;
    private String goodsCode;
    private String goodsName;
    private String goodsModel;
    private Integer goodsNum;
    private String goodsUnit;
    private double price;
    private double total;
    //private Integer saleListId;
    private Integer goodsTypeId;

}
