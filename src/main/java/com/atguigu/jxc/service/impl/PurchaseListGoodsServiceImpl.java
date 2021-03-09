package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListGoodsDao;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.atguigu.jxc.vo.OrderVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {
    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;


    public void updateState(Integer purchaseListId) {
        purchaseListGoodsDao.updateState(purchaseListId);
    }

    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<OrderVO> orderVOList = this.purchaseListGoodsDao.count(sTime, eTime, goodsTypeId, codeOrName);
        Gson gson = new Gson();
        return gson.toJson(orderVOList);
    }
}