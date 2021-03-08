package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 客户dao
 */
public interface SaleListGoodsDao {

    List<SaleList> getSaleListList(@Param("saleNumber") String saleNumber,
                                        @Param("customerId") Integer customerId,
                                        @Param("state") Integer state,
                                        @Param("sTime") String sTime,
                                        @Param("eTime") String eTime);

    List<SaleListGoods> getSaleListGoodsList(Integer saleListId);

    void deleteGoods(Integer saleListId);

    void deleteSaleList(Integer saleListId);
}
