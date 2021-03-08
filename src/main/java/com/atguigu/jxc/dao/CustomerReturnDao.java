package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 客户dao
 */
public interface CustomerReturnDao {

    List<ReturnList> getReturnList(@Param("returnNumber") String returnNumber,
                                   @Param("customerId") Integer customerId,
                                   @Param("state") Integer state,
                                   @Param("sTime") String sTime,@Param("eTime") String eTime);

    List<ReturnListGoods> getReturnGoodsList(Integer customerReturnListId);

    void deleteReturnGoods(Integer customerReturnListId);

    void deleteReturnList(Integer customerReturnListId);
}
