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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, List<PurchaseList>> OrderInquity(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime) {
        //TOOD: 此处应判断传递参数是否合法


        HashMap<String, List<PurchaseList>> map = new HashMap();
        List<PurchaseList> orderInquity = purchaseListGoodsDao.findOrderInquity(purchaseNumber, supplierId, state, sTime, eTime);
        //前端接收类型为Json，key必须为rows
        map.put("rows", orderInquity);
        return map;
    }

    @Override
    public Map<String, Object> MerchandiseNews(Integer purchaseListId) {
        HashMap<String, Object> map = new HashMap<>();
        List<PurchaseListGoods> purchaseListGoods = this.purchaseListGoodsDao.findMerchandiseNewsById(purchaseListId);
        //前端接收类型为Json，key必须为rows
        map.put("rows", purchaseListGoods);
        return map;
    }

    @Override
    public void DeleteOrder(Integer purchaseListId) {
        this.purchaseListGoodsDao.DeleteOrder(purchaseListId);
    }
}
