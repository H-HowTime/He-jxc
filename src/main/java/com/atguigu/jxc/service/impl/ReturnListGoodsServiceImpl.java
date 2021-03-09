package com.atguigu.jxc.service.impl;


import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.ReturnListDao;
import com.atguigu.jxc.dao.ReturnListGoodsDao;
import com.atguigu.jxc.entity.*;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘兴龙
 * @create 2021-03-08 15:05
 */
@Service
public class ReturnListGoodsServiceImpl implements ReturnListGoodsService {

    @Autowired
    private ReturnListDao returnListDao;
    @Autowired
    private ReturnListGoodsDao returnListGoodsDao;
    @Autowired
    private GoodsService goodsService;
//    @Autowired
////    private GoodsDao goodsDao;


    @Override
    public void save(CustomerReturnList customerReturnList, String customerReturnListGoodsStr, String returnNumber) {

        returnListDao.save(customerReturnList);

        CustomerReturnListGoods customerReturnListGoods = new CustomerReturnListGoods();
        Gson gson = new Gson();

        List<CustomerReturnListGoods> ps = gson.fromJson(customerReturnListGoodsStr, new TypeToken<List<CustomerReturnListGoods>>() {
        }.getType());
        for (int i = 0; i < ps.size(); i++) {
            CustomerReturnListGoods p = ps.get(i);

            customerReturnListGoods.setCustomerReturnListGoodsId(p.getCustomerReturnListGoodsId());
            customerReturnListGoods.setCustomerReturnListId(p.getCustomerReturnListId());
            customerReturnListGoods.setGoodsCode(p.getGoodsCode());
            customerReturnListGoods.setGoodsName(p.getGoodsName());
            customerReturnListGoods.setGoodsId(p.getGoodsId());
            customerReturnListGoods.setGoodsModel(p.getGoodsModel());
            customerReturnListGoods.setGoodsTypeId(p.getGoodsTypeId());
            customerReturnListGoods.setGoodsNum(p.getGoodsNum());
            customerReturnListGoods.setPrice(p.getPrice());
            customerReturnListGoods.setGoodsUnit(p.getGoodsUnit());
            customerReturnListGoods.setTotal(p.getTotal());
            returnListGoodsDao.save(customerReturnListGoods);

            Integer count = goodsService.query(p.getGoodsId());

            Integer s=count +p.getGoodsNum();

            goodsService.saveStock(p.getGoodsId(),s,p.getPrice());

            //System.out.println(p.toString());
        }

    }
}
