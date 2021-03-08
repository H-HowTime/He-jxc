package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerDao;
import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.CustomerService;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 */
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    private LogService logService;
    @Autowired
    private SaleListGoodsDao saleListGoodsDao;

    @Override
    public void deleteGoods(Integer saleListId) {
        this.saleListGoodsDao.deleteGoods(saleListId);
        this.saleListGoodsDao.deleteSaleList(saleListId);
    }

    @Override
    public Map<String, Object> goodsList(Integer saleListId) {
        Map<String,Object> map = new HashMap<>();

        // 查询类别ID为当前ID或父ID为当前类别ID的商品
        List<SaleListGoods> saleListGoodsList = saleListGoodsDao.getSaleListGoodsList(saleListId);

        map.put("rows", saleListGoodsList);

//        logService.save(new Log(Log.SELECT_ACTION, "销售单查询"));

        return map;
    }

    @Override
    public Map<String, Object> list(String saleNumber, Integer customerId, Integer state, String sTime, String eTime) {
        Map<String,Object> map = new HashMap<>();

        // 查询类别ID为当前ID或父ID为当前类别ID的商品
        List<SaleList> saleListGoodsList = saleListGoodsDao.getSaleListList(saleNumber, customerId, state, sTime, eTime);

        map.put("rows", saleListGoodsList);

//        logService.save(new Log(Log.SELECT_ACTION, "销售单查询"));

        return map;
    }
}
