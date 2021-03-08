package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.ReturnListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wrsstart
 * @creat 2021-03-08 18:30
 */
public interface ReturnListGoodsDao {
    void save(@Param("returnListGoodsList") List<ReturnListGoods> returnListGoodsList);
}
