package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.SaleDataDayVo;
import com.atguigu.jxc.domain.SaleListGoodsVo;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author hehao
 * @create 2021-03-08 12:51
 */
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    private SaleListGoodsDao saleListGoodsDao;

    @Override
    public void updateState(Integer saleListId) {
        saleListGoodsDao.updateState(saleListId);
    }

    @Override
    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<SaleListGoodsVo> saleListGoodsVos = this.saleListGoodsDao.count(sTime, eTime, goodsTypeId, codeOrName);
        Gson gson = new Gson();
        return gson.toJson(saleListGoodsVos);
    }

    @Override
    public String getSaleDataByDay(String sTime, String eTime) {
        //日销售总额、成本总额、盈利总额数据
        List<SaleDataDayVo> saleDataDayVos = saleListGoodsDao.getSaleDataByDay(sTime, eTime);
        if (CollectionUtils.isEmpty(saleDataDayVos)) {
            return null;
        }
        saleDataDayVos.forEach(saleDataDayVo -> {
            if (StringUtils.isEmpty(saleDataDayVo.getDate())) {
                saleDataDayVo.setSaleTotal(0d);
                saleDataDayVo.setDate(saleDataDayVo.getPurchaseDate());
                saleDataDayVo.setProfit(0 - saleDataDayVo.getPurchasingTotal());
            } else {
                double temp = saleDataDayVo.getPurchasingTotal() == null ? 0 : saleDataDayVo.getPurchasingTotal();
                saleDataDayVo.setProfit(saleDataDayVo.getSaleTotal() - temp);
                saleDataDayVo.setPurchasingTotal(temp);
            }
        });
        Gson gson = new Gson();
        return gson.toJson(saleDataDayVos);
    }
}
