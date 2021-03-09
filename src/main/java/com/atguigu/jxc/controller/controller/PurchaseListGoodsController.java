package com.atguigu.jxc.controller.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchaseListGoods")
public class PurchaseListGoodsController {

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    /**
     * 更新进货订单的付款状态
     * @param purchaseListId
     * @return
     */
    @PostMapping("updateState")
    public ServiceVO<String> updateState(@RequestParam("purchaseListId") Integer purchaseListId) {
        purchaseListGoodsService.updateState(purchaseListId);
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    /**
     * 按条件查询采购列表
     * @param sTime
     * @param eTime
     * @param goodsTypeId
     * @param codeOrName
     * @return
     */
    @PostMapping("count")
    public String count(
            @RequestParam("sTime") String sTime,
            @RequestParam("eTime") String eTime,
            @RequestParam("goodsTypeId") Integer goodsTypeId,
            @RequestParam("codeOrName") String codeOrName
    ) {
        return purchaseListGoodsService.count(sTime, eTime, goodsTypeId, codeOrName);
    }
}
