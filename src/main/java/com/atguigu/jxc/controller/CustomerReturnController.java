package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerReturnService;
import com.atguigu.jxc.service.CustomerService;
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
@RequestMapping("/customerReturnListGoods")
public class CustomerReturnController {

    @Autowired
    private CustomerReturnService customerReturnService;

    @PostMapping("list")
    public Map<String, Object> getList(String returnNumber, Integer customerId, Integer state, String sTime,String eTime) {
        return customerReturnService.getReturnList( returnNumber,  customerId,  state,  sTime, eTime);
    }

    @PostMapping("goodsList")
    public Map<String, Object> getGoodsList(Integer customerReturnListId) {
        return customerReturnService.getGoodsList(customerReturnListId);
    }

    @PostMapping("delete")
    public ServiceVO deleteReturnList(Integer customerReturnListId) {
        customerReturnService.deleteReturnList(customerReturnListId);
        return new ServiceVO(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
