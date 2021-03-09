package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListGoodsDao;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wrsstart
 * @creat 2021-03-08 18:29
 */
@Service
@Transactional
public class ReturnListGoodsServiceImpl implements ReturnListGoodsService {

    @Autowired
    private ReturnListGoodsDao returnListGoodsDao;

    @Override
    public void save(String returnListGoodsStr, Integer returnListId) {
        Gson gson = new Gson();
        List<ReturnListGoods> returnListGoodsList = gson.fromJson(returnListGoodsStr, new TypeToken<List<ReturnListGoods>>() {}.getType());
        returnListGoodsList.forEach(returnListGoods -> {
            returnListGoods.setReturnListId(returnListId);
        });
        this.returnListGoodsDao.save(returnListGoodsList);
    }
}
