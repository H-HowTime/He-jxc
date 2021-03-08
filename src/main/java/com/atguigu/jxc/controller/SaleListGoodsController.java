package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description 客户Controller控制器
 */
@RestController
@RequestMapping("/saleListGoods")
public class SaleListGoodsController {

    @Autowired
    private SaleListGoodsService saleListGoodsService;

    /**
     *
     * @param saleNumber
     * @param customerId
     * @param state
     * @param sTime
     * @param eTime
     * @return
     */
    @PostMapping("list")
    public Map<String,Object> list(String saleNumber, Integer customerId, Integer state, String sTime,String eTime) {
        return saleListGoodsService.list(saleNumber, customerId, state, sTime,eTime);
    }

    /**
     *
     * @param saleListId
     * @return
     */
    @PostMapping("goodsList")
    public Map<String,Object> goodsList(Integer saleListId) {
        return saleListGoodsService.goodsList(saleListId);
    }

    @PostMapping("delete")
    public ServiceVO delete(Integer saleListId) {
        saleListGoodsService.deleteGoods(saleListId);
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
