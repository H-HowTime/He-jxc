package com.atguigu.jxc.service;

public interface PurchaseListGoodsService {
    void updateState(Integer purchaseListId);

    String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}