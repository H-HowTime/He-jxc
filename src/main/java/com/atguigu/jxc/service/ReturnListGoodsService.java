package com.atguigu.jxc.service;


import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.entity.ReturnList;

/**
 * @author 刘兴龙
 * @create 2021-03-08 14:00
 */

public interface ReturnListGoodsService {


    void save(CustomerReturnList customerReturnList, String customerReturnListGoodsStr, String returnNumber);
}
