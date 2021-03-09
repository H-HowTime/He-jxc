package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.SaleDataDayVo;
import com.atguigu.jxc.domain.SaleListGoodsVo;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hehao
 * @create 2021-03-08 12:51
 */
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    private SaleListGoodsDao saleListGoodsDao;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SaleListDao saleListDao;

    @Override
    public void updateState(Integer saleListId) {
        saleListGoodsDao.updateState(saleListId);
    }

    @Override
    public String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<SaleListGoodsVo> saleListGoodsVos = this.saleListGoodsDao.count(sTime, eTime, goodsTypeId, codeOrName);
        Gson gson = new Gson();
        return gson.toJson(saleListGoodsVos);
    }

    @Override
    public String getSaleDataByDay(String sTime, String eTime) {
        //日销售总额、成本总额、盈利总额数据
        List<SaleDataDayVo> saleDataDayVos = saleListGoodsDao.getSaleDataByDay(sTime, eTime);
        if (CollectionUtils.isEmpty(saleDataDayVos)) {
            return null;
        }
        saleDataDayVos.forEach(saleDataDayVo -> {
            if (StringUtils.isEmpty(saleDataDayVo.getDate())) {
                saleDataDayVo.setSaleTotal(0d);
                saleDataDayVo.setDate(saleDataDayVo.getPurchaseDate());
                saleDataDayVo.setProfit(0 - saleDataDayVo.getPurchasingTotal());
            } else {
                double temp = saleDataDayVo.getPurchasingTotal() == null ? 0 : saleDataDayVo.getPurchasingTotal();
                saleDataDayVo.setProfit(saleDataDayVo.getSaleTotal() - temp);
                saleDataDayVo.setPurchasingTotal(temp);
            }
        });
        Gson gson = new Gson();
        return gson.toJson(saleDataDayVos);
    }


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


    @SneakyThrows
    @Override
    @Transactional
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
            Integer count = goodsService.query(p.getGoodsId());


            if (count>=p.getGoodsNum()){
                Integer s= count-p.getGoodsNum();

                goodsService.saveStock(p.getGoodsId(),s,p.getPrice());
            }else {
                throw new RuntimeException("该商品库存数量不足");
            }

            //System.out.println(p.toString());
        }

    }
}