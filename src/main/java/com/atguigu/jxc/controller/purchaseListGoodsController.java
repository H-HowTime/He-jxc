package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.PurchaseListAndGoods;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.atguigu.jxc.service.PurchaseListService;
import com.google.gson.Gson;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author huima9527
 * @create 2021-03-08 10:45
 */
@RestController
@RequestMapping("/purchaseListGoods")
public class purchaseListGoodsController {

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    @Autowired
    private PurchaseListService purchaseListService;

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
    /**
     * 根据以下条件之一查询订货单信息
     * @param purchaseNumber 单据号
     * @param supplierId    供应商
     * @param state     是否付款
     * @param sTime     起始日期
     * @param eTime     截止日期
     * @return
     */
    @PostMapping("/list")
    public String OrderInquiry(String purchaseNumber, Integer supplierId, Integer state, String sTime,String eTime){
        Map<String, List<PurchaseList>> map = this.purchaseListGoodsService.OrderInquity(purchaseNumber,supplierId,state,sTime,eTime);
        Gson gson = new Gson();
        String OrderMap = gson.toJson(map);
        return OrderMap;
    }

    /**
     *  根据订货单ID查询订货单商品信息
     * @param purchaseListId  订货单ID
     * @return
     */
    @PostMapping("/goodsList")
    public String MerchandiseNews(Integer purchaseListId){
        Map<String,Object> map = this.purchaseListGoodsService.MerchandiseNews(purchaseListId);
        Gson gson = new Gson();
        String OrderMap = gson.toJson(map);
        return OrderMap;
    }

    /**
     *  根据订货单ID删除订货单
     * @param purchaseListId  订单ID
     * @return  成功就返回数据
     */
    @PostMapping("/delete")
    public String DeleteOrder(Integer purchaseListId){
        String serviceVo = null;
        try {
            //注意：这里并没有把他的关联表t_purchase_list_goods中该订单的数据删除，而且并没有测试
            this.purchaseListGoodsService.DeleteOrder(purchaseListId);
            Gson gson = new Gson();
            ServiceVO serviceVO = new ServiceVO(100, "请求成功", null);
            serviceVo = gson.toJson(serviceVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceVo;
    }

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
