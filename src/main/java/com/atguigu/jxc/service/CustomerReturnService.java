package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Customer;

import java.util.Map;

/**
 * @description
 */
public interface CustomerReturnService {


    Map<String, Object> getReturnList(String returnNumber, Integer customerId, Integer state, String sTime, String eTime);

    Map<String, Object> getGoodsList(Integer customerReturnListId);

    void deleteReturnList(Integer customerReturnListId);
}
