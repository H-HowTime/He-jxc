package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.SaleDataDayVo;
import com.atguigu.jxc.domain.SaleListGoodsVo;
import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.entity.DamageListGoods;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 商品报损
 */
@Mapper
public interface SaleListGoodsDao {

    Integer updateState(Integer saleListId);

    List<SaleListGoodsVo> count(@Param("sTime") String sTime,
                                @Param("eTime") String eTime,
                                @Param("goodsTypeId") Integer goodsTypeId,
                                @Param("codeOrName") String codeOrName);

    List<SaleDataDayVo> getSaleDataByDay(@Param("sTime") String sTime,
                                         @Param("eTime") String eTime);



    List<SaleList> getSaleListList(@Param("saleNumber") String saleNumber,
                                   @Param("customerId") Integer customerId,
                                   @Param("state") Integer state,
                                   @Param("sTime") String sTime,
                                   @Param("eTime") String eTime);

    List<SaleListGoods> getSaleListGoodsList(Integer saleListId);

    void deleteGoods(Integer saleListId);

    void deleteSaleList(Integer saleListId);

    List<Integer> querySaleListGoodsId(Integer saleListId);

    void save(SaleListGoods saleListGoods);
}

