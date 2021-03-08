package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;

/**
 * @author wrsstart
 * @creat 2021-03-08 14:18
 */
public interface PurchaseListGoodsService {

    void save(String purchaseListGoodsStr, Integer purchaseListId);

}
