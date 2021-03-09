package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerReturnListGoodsDao;
import com.atguigu.jxc.domain.SaleListGoodsVoH;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hehao
 * @create 2021-03-08 16:04
 */
@Service
public class CustomerReturnListGoodsServiceImpl implements CustomerReturnListGoodsService {
    @Autowired
    private CustomerReturnListGoodsDao customerReturnListGoodsDao;

    @Override
    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<SaleListGoodsVoH> saleListGoodsVos = this.customerReturnListGoodsDao.count(sTime, eTime, goodsTypeId, codeOrName);
        Gson gson = new Gson();
        return gson.toJson(saleListGoodsVos);
    }
}
