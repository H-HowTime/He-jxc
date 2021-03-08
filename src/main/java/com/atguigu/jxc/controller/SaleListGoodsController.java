package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SaleListGoodsVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 刘兴龙
 * @create 2021-03-08 13:47
 */
@RestController
@RequestMapping("saleListGoods")
public class SaleListGoodsController {

    @Autowired
    private SaleListGoodsService saleListGoodsService;

    @PostMapping("save")
    public ServiceVO<Object> save(@RequestParam("saleNumber")String saleNumber,
                                  SaleList saleList,
                                  String saleListGoodsStr
            ) {
        saleListGoodsService.save(saleList,saleListGoodsStr,saleNumber);
         return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

}
