package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;

import java.util.Map;

/**
 * @author wrsstart
 * @creat 2021-03-08 18:29
 */
public interface ReturnListGoodsService {
    ServiceVO save(String returnListGoodsStr, Integer returnListId);


    Map<String, Object> salesReturn(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime);

    Map<String, Object> salesReturnNews(Integer returnListId);

    void deleteSalesReturn(Integer returnListId);
    void saveCust(CustomerReturnList customerReturnList, String customerReturnListGoodsStr, String returnNumber);

}
