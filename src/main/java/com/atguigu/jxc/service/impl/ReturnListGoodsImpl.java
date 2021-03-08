package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListGoodsDao;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.service.ReturnListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huima9527
 * @create 2021-03-08 16:41
 */
@Service
public class ReturnListGoodsImpl implements ReturnListGoodsService {
    @Autowired
    private ReturnListGoodsDao returnListGoodsDao;

    @Override
    public Map<String, Object> salesReturn(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime) {
        /**
         * 此时应该做参数校验，省略没做
         */
        List<ReturnList> ReturnList = this.returnListGoodsDao.salesReturn(returnNumber, supplierId, state, sTime, eTime);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", ReturnList);
        return map;
    }

    @Override
    public Map<String, Object> salesReturnNews(Integer returnListId) {
        Map<String, Object> map = new HashMap<>();
        List<ReturnListGoods> returnListGoods = this.returnListGoodsDao.salesReturnNews(returnListId);
        map.put("rows",returnListGoods);
        return map;
    }

    @Override
    public void deleteSalesReturn(Integer returnListId) {
        this.returnListGoodsDao.deleteSalesReturn(returnListId);
    }


}
