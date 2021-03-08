package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Customer;

import java.util.Map;

/**
 * @description
 */
public interface SaleListGoodsService {

    Map<String, Object> list(String saleNumber, Integer customerId, Integer state, String sTime, String eTime);

    Map<String, Object> goodsList(Integer saleListId);

    void deleteGoods(Integer saleListId);
}
