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

}
