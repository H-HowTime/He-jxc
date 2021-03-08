package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘兴龙
 * @create 2021-03-08 13:47
 */
@RestController
@RequestMapping("customerReturnListGoods")
public class CustomerListGoodsController {

    @Autowired
    private ReturnListGoodsService returnListGoodsService;

    @PostMapping("save")
    public ServiceVO<Object> save(@RequestParam("returnNumber")String returnNumber,
                                  CustomerReturnList customerReturnList,
                                  String customerReturnListGoodsStr) {
        returnListGoodsService.save(customerReturnList,customerReturnListGoodsStr,returnNumber);
         return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

}
