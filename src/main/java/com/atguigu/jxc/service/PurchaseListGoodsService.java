package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;

import java.util.Map;

/**
 * @author wrsstart
 * @creat 2021-03-08 14:18
 */
public interface PurchaseListGoodsService {

    void save(String purchaseListGoodsStr, Integer purchaseListId);

    void updateState(Integer purchaseListId);

    String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);

    Map<String, List<PurchaseList>> OrderInquity(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime);

    Map<String, Object> MerchandiseNews(Integer purchaseListId);

    void DeleteOrder(Integer purchaseListId);
}
