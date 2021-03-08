package com.atguigu.jxc.domain;

import lombok.Data;

/**
 * @author wrsstart
 * @creat 2021-03-08 16:10
 */
@Data
public class PurchaseListAndGoods {


    private double amountPaid;
    private double amountPayable;
    private String purchaseDate;
    private String remarks;
    private Integer state;
    private Integer supplierId;

    private String purchaseListGoodsStr;

}
