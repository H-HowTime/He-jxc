package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.purchaseListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author huima9527
 * @create 2021-03-08 10:45
 */
@RestController
@RequestMapping("/purchaseListGoods")
public class purchaseListGoodsController {

    @Autowired
    private com.atguigu.jxc.service.purchaseListGoodsService purchaseListGoodsService;

    @PostMapping("/list")
    public String OrderInquiry(String purchaseNumber, Integer supplierId, Integer state, String sTime,String eTime){
        Map<String,Object> hashmap = this.purchaseListGoodsService.OrderInquity(purchaseNumber,supplierId,state,sTime,eTime);
        
        return null;
    }
}
