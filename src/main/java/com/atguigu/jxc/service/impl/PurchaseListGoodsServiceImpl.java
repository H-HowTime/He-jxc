package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListGoodsDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.atguigu.jxc.vo.OrderVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wrsstart
 * @creat 2021-03-08 14:18
 */
@Service
@Transactional
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {

    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;

    @Autowired
    private GoodsService goodsService;


    @Override
    public void save(String purchaseListGoodsStr, Integer purchaseListId) {
        Gson gson = new Gson();
        List<PurchaseListGoods> purchaseListGoodsList = gson.fromJson(purchaseListGoodsStr, new TypeToken<List<PurchaseListGoods>>() {}.getType());
        purchaseListGoodsList.forEach(purchaseListGoods -> {
            purchaseListGoods.setPurchaseListId(purchaseListId);
            goodsService.incrStore(purchaseListGoods.getGoodsId(), purchaseListGoods.getGoodsNum());
        });
        this.purchaseListGoodsDao.save(purchaseListGoodsList);
    }


    public PurchaseListGoodsServiceImpl() {
    }

    public void updateState(Integer purchaseListId) {
        purchaseListGoodsDao.updateState(purchaseListId);
    }

    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<OrderVO> orderVOList = this.purchaseListGoodsDao.count(sTime, eTime, goodsTypeId, codeOrName);
        Gson gson = new Gson();
        return gson.toJson(orderVOList);
    }
}
