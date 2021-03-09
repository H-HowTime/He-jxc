package com.atguigu.jxc.dao;

import com.atguigu.jxc.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PurchaseListGoodsDao {
    int updateState(@Param("purchaseListId") Integer purchaseListId);

    List<OrderVO> count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
