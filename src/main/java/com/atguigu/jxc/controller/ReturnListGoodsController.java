package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.atguigu.jxc.service.ReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author wrsstart
 * @creat 2021-03-08 18:13
 */
@RestController
@RequestMapping("returnListGoods")
public class ReturnListGoodsController {

    @Autowired
    private ReturnListService returnListService;

    @Autowired
    private ReturnListGoodsService returnListGoodsService;

    /**
     * 退货清单保存
     * @return
     */
    @PostMapping("save")
    public ServiceVO save(
            @RequestParam("returnNumber")String returnNumber,
            ReturnList returnList,
            String returnListGoodsStr,
            HttpServletRequest request
    ){
        returnList.setReturnNumber(returnNumber);
        this.returnListService.save(returnList, request.getSession());
        Integer returnListId = returnList.getReturnListId();

        ServiceVO serviceVO = this.returnListGoodsService.save(returnListGoodsStr, returnListId);

        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }



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
