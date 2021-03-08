package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.purchaseListGoodsDao;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huima9527
 * @create 2021-03-08 11:46
 */
@Service
public class PurchaseListGoodsImpl implements PurchaseListGoodsService {
    @Autowired
    private LogService logService;
    @Autowired
    private purchaseListGoodsDao purchaseListGoodsDao;

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
