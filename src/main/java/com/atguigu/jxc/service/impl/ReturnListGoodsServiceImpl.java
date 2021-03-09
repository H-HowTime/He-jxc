package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListGoodsDao;
import com.atguigu.jxc.domain.ErrorCode;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wrsstart
 * @creat 2021-03-08 18:29
 */
@Service
@Transactional
public class ReturnListGoodsServiceImpl implements ReturnListGoodsService {

    @Autowired
    private ReturnListGoodsDao returnListGoodsDao;

    @Autowired
    private GoodsService goodsService;

    @Override
    public ServiceVO save(String returnListGoodsStr, Integer returnListId) {
        Gson gson = new Gson();
        List<ReturnListGoods> returnListGoodsList = gson.fromJson(returnListGoodsStr, new TypeToken<List<ReturnListGoods>>() {}.getType());
        try {
            returnListGoodsList.forEach(returnListGoods -> {
                returnListGoods.setReturnListId(returnListId);
                ServiceVO serviceVO = goodsService.decrStore(returnListGoods.getGoodsId(), returnListGoods.getGoodsNum());
                if (serviceVO.getCode() != 100){
                    throw new RuntimeException("库存不足");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceVO(ErrorCode.STORE_OUT_OF_ERROR_CODE, ErrorCode.STORE_OUT_OF_ERROR_MESS);
        }
        this.returnListGoodsDao.save(returnListGoodsList);
        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

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
