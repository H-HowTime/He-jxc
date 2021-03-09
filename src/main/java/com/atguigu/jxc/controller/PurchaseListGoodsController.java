package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.PurchaseListAndGoods;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.atguigu.jxc.service.PurchaseListService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wrsstart
 * @creat 2021-03-08 14:11
 */
@RestController
@RequestMapping("/purchaseListGoods")
public class PurchaseListGoodsController {

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    @Autowired
    private PurchaseListService purchaseListService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 进货单保存
     * @param purchaseNumber
     * @return
     */
    @PostMapping("save")
    public ServiceVO save(
            PurchaseListAndGoods purchaseListAndGoods,
            @RequestParam("purchaseNumber") String purchaseNumber,
            HttpServletRequest request
    ){

        PurchaseList purchaseList = new PurchaseList();
        BeanUtils.copyProperties(purchaseListAndGoods, purchaseList);

        String purchaseListGoodsStr = purchaseListAndGoods.getPurchaseListGoodsStr();

        this.purchaseListService.save(purchaseList, purchaseNumber, request.getSession());

        Integer purchaseListId = purchaseList.getPurchaseListId();
        this.purchaseListGoodsService.save(purchaseListGoodsStr, purchaseListId);


        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS, null);
    }

}
