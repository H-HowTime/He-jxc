package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huima9527
 * @create 2021-03-08 16:39
 */
@RestController
@RequestMapping("/returnListGoods")
public class ReturnListGoodsController {
    @Autowired
    private ReturnListGoodsService returnListGoodsService;

    /**
     * 根据用户输入的查询条件查询退款单信息
     * @param returnNumber  退款单号
     * @param supplierId    供应商
     * @param state     是否退款 1：已退款  2：未退款
     * @param sTime     起始时间
     * @param eTime     截止时间
     * @return
     */
    @PostMapping("/list")
    public String salesReturn(String returnNumber,Integer supplierId, Integer state,String sTime,String eTime){
        Map<String,Object> map = this.returnListGoodsService.salesReturn(returnNumber,supplierId,state,sTime,eTime);
        Gson gson = new Gson();
        String sales = gson.toJson(map);
        return sales;
    }

    /**
     * 根据退货订单ID查询退货订单商品信息
     * @param returnListId  退货订单ID
     * @return
     */
    @PostMapping("/goodsList")
    public String salesReturnNews(Integer returnListId){
        Map<String,Object> map = this.returnListGoodsService.salesReturnNews(returnListId);
        Gson gson = new Gson();
        String saleMap = gson.toJson(map);
        return saleMap;
    }

    /**
     * 根据退货订单ID删除退货订单
     * @param returnListId  退货订单
     * @return
     */
    @PostMapping("/delete")
    public String deleteSalesReturn(Integer returnListId){
        String salereturn = null;
        try {
            this.returnListGoodsService.deleteSalesReturn(returnListId);
            Gson gson = new Gson();
            ServiceVO serviceVO = new ServiceVO(100, "请求成功", null);
            salereturn = gson.toJson(serviceVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salereturn;
    }

}
