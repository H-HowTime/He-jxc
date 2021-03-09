package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wrsstart
 * @creat 2021-03-08 14:19
 */
public interface PurchaseListGoodsDao {

    void save(@Param("purchaseListGoodsList") List<PurchaseListGoods> purchaseListGoodsList);



    int updateState(@Param("purchaseListId") Integer purchaseListId);

    List<OrderVO> count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
