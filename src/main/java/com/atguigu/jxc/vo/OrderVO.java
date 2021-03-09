package com.atguigu.jxc.vo;

import lombok.Data;

@Data
public class OrderVO {
    private Integer purchaseListId;
    private String number;
    private String date;
    private Integer supplierId;
    private String supplierName;
    private String code;
    private String name;
    private String model;
    private String unit;
    private Integer num;
    private double price;
    private double total;
    private Integer goodsTypeId;
    private String goodsType;
}