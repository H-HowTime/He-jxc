package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.purchaseListGoodsDao;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.purchaseListGoodsService;
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
public class purchaseListGoodsImpl implements purchaseListGoodsService {
    @Autowired
    private LogService logService;
    @Autowired
    private purchaseListGoodsDao purchaseListGoodsDao;

    @Override
    public Map<String, List<PurchaseList>> OrderInquity(String purchaseNumber, Integer supplierId, Integer state, String sTime, String eTime) {
        HashMap<String, List<PurchaseList>> map = new HashMap();
       List<PurchaseList> orderInquity = purchaseListGoodsDao.findOrderInquity(purchaseNumber,supplierId,state,sTime,eTime);

        map.put("rows",orderInquity);
        return map;
    }
}
