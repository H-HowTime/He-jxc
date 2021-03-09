package com.atguigu.jxc.dao;


import com.atguigu.jxc.domain.SaleListGoodsVoH;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hehao
 * @create 2021-03-08 16:04
 */
@Mapper
public interface CustomerReturnListGoodsDao {
    List<SaleListGoodsVoH> count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
