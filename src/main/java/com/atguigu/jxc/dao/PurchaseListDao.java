package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.PurchaseList;
import org.apache.ibatis.annotations.Param;

/**
 * @author wrsstart
 * @creat 2021-03-08 14:38
 */
public interface PurchaseListDao {
    int save(PurchaseList purchaseList);
}
