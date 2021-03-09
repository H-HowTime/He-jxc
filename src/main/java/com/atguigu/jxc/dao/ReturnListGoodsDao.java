package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.CustomerReturnListGoods;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wrsstart
 * @creat 2021-03-08 18:30
 */
public interface ReturnListGoodsDao {
    void save(@Param("returnListGoodsList") List<ReturnListGoods> returnListGoodsList);
    List<ReturnList> salesReturn(@Param("returnNumber") String returnNumber, @Param("supplierId") Integer supplierId, @Param("state") Integer state, @Param("sTime")  String sTime, @Param("eTime")  String eTime);

    List<ReturnListGoods> salesReturnNews(Integer returnListId);

    void deleteSalesReturn(Integer returnListId);

    void saveCust(CustomerReturnListGoods customerReturnListGoods);
}
