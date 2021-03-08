package com.atguigu.jxc.service.impl;


import com.atguigu.jxc.dao.SaleListDao;
import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.SaleListGoodsVO;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘兴龙
 * @create 2021-03-08 15:05
 */
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    private SaleListGoodsDao saleListGoodsDao;
    @Autowired
    private SaleListDao saleListDao;


    @SneakyThrows
    @Override
    public void save(SaleList saleList, String saleListGoodsStr, String saleNumber) {
        saleList.setSaleNumber(saleNumber);
        saleListDao.save(saleList);
//        Integer saleListId = saleList.getSaleListId();
//
//
//        //再保存sale_list_goods
//        List<Integer> saleListGoodsIds = saleListGoodsDao.querySaleListGoodsId(saleListId);
        SaleListGoods saleListGoods = new SaleListGoods();
        Gson gson = new Gson();

        List<SaleListGoods> ps = gson.fromJson(saleListGoodsStr, new TypeToken<List<SaleListGoods>>() {
        }.getType());
        for (int i = 0; i < ps.size(); i++) {
            SaleListGoods p = ps.get(i);
            saleListGoods.setGoodsName(p.getGoodsName());
            saleListGoods.setGoodsNum(p.getGoodsNum());
            saleListGoods.setSaleListGoodsId(p.getSaleListGoodsId());
            saleListGoods.setTotal(p.getTotal());
            saleListGoods.setGoodsCode(p.getGoodsCode());
            saleListGoods.setGoodsId(p.getGoodsId());
            saleListGoods.setGoodsModel(p.getGoodsModel());
            saleListGoods.setGoodsTypeId(p.getGoodsTypeId());
            saleListGoods.setGoodsUnit(p.getGoodsUnit());
            saleListGoods.setPrice(p.getPrice());
            saleListGoods.setSaleListId(p.getSaleListId());
            saleListGoodsDao.save(saleListGoods);
            //System.out.println(p.toString());
        }

    }
}