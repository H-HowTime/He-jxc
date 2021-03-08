package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huima9527
 * @create 2021-03-08 13:15
 */
public interface purchaseListGoodsDao {
    List<PurchaseList> findOrderInquity(@Param("purchaseNumber") String purchaseNumber, @Param("supplierId") Integer supplierId, @Param("state") Integer state, @Param("sTime") String sTime, @Param("eTime") String eTime);
}
