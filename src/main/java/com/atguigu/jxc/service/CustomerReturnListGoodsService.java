package com.atguigu.jxc.service;

/**
 * @author hehao
 * @create 2021-03-08 16:03
 */
public interface CustomerReturnListGoodsService {
    String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
