package com.atguigu.jxc.service;

import java.util.Map;

/**
 * @author hehao
 * @create 2021-03-08 12:51
 */
public interface SaleListGoodsService {
    void updateState(Integer saleListId);

    String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);

    String getSaleDataByDay(String sTime, String eTime);


    Map<String, Object> list(String saleNumber, Integer customerId, Integer state, String sTime, String eTime);

    Map<String, Object> goodsList(Integer saleListId);

    void deleteGoods(Integer saleListId);
}

