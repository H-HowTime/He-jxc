package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.PurchaseList;

import java.util.List;
import java.util.Map;

/**
 * @author huima9527
 * @create 2021-03-08 10:51
 */
public interface purchaseListGoodsService {

    Map<String, List<PurchaseList>> OrderInquity(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime);
}
