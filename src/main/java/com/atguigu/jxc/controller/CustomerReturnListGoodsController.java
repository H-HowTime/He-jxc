package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hehao
 * @create 2021-03-08 16:03
 */
@RestController
@RequestMapping("customerReturnListGoods")
public class CustomerReturnListGoodsController {

    @Autowired
    private CustomerReturnListGoodsService customerReturnListGoodsService;

    /**
     * 商品退货统计 --根据商品类别/商品编码/名称 条件查询
     *
     * @return
     */
    @PostMapping("/count")
    public String count(@RequestParam("sTime") String sTime,
                        @RequestParam("eTime") String eTime,
                        @RequestParam("goodsTypeId") Integer goodsTypeId,
                        @RequestParam("codeOrName") String codeOrName) {
        String saleListGoodsVosJson = this.customerReturnListGoodsService.count(sTime, eTime, goodsTypeId, codeOrName);
        return saleListGoodsVosJson;
    }

}
