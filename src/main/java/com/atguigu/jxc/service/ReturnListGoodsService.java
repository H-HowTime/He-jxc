package com.atguigu.jxc.service;

import java.util.Map;

/**
 * @author huima9527
 * @create 2021-03-08 16:41
 */
public interface ReturnListGoodsService {
    Map<String, Object> salesReturn(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime);

    Map<String, Object> salesReturnNews(Integer returnListId);

    void deleteSalesReturn(Integer returnListId);
}
