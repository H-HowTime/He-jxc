package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerDao;
import com.atguigu.jxc.dao.CustomerReturnDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.ReturnListGoods;
import com.atguigu.jxc.service.CustomerReturnService;
import com.atguigu.jxc.service.CustomerService;
import com.atguigu.jxc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 */
@Service
public class CustomerReturnServiceImpl implements CustomerReturnService {

    @Autowired
    private LogService logService;
    @Autowired
    private CustomerReturnDao customerReturnDao;

    @Override
    public void deleteReturnList(Integer customerReturnListId) {
        customerReturnDao.deleteReturnList(customerReturnListId);
        customerReturnDao.deleteReturnGoods(customerReturnListId);
    }

    @Override
    public Map<String, Object> getGoodsList(Integer customerReturnListId) {
        Map<String,Object> map = new HashMap<>();

        // 查询类别ID为当前ID或父ID为当前类别ID的商品
        List<ReturnListGoods> saleListGoodsList = customerReturnDao.getReturnGoodsList(customerReturnListId);

        map.put("rows", saleListGoodsList);

//        logService.save(new Log(Log.SELECT_ACTION, "销售单查询"));

        return map;
    }

    @Override
    public Map<String, Object> getReturnList(String returnNumber, Integer customerId, Integer state, String sTime, String eTime) {
        Map<String,Object> map = new HashMap<>();

        // 查询类别ID为当前ID或父ID为当前类别ID的商品
        List<ReturnList> saleListGoodsList = customerReturnDao.getReturnList( returnNumber,  customerId,  state,  sTime, eTime);

        map.put("rows", saleListGoodsList);

//        logService.save(new Log(Log.SELECT_ACTION, "销售单查询"));

        return map;
    }
}
