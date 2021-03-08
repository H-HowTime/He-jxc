package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.SaleListGoods;

import java.util.List;

/**
 * @author 刘兴龙
 * @create 2021-03-08 14:43
 */
public interface SaleListGoodsDao {


    List<Integer> querySaleListGoodsId(Integer saleListId);

    void save(SaleListGoods saleListGoods);
}
