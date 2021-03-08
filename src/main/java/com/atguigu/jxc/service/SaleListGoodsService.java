package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.SaleListGoodsVO;
import com.atguigu.jxc.entity.SaleList;

/**
 * @author 刘兴龙
 * @create 2021-03-08 14:00
 */

public interface SaleListGoodsService {


    void save(SaleList saleList, String saleListGoodsStr, String saleNumber);
}
