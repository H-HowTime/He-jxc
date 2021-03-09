package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;

/**
 * @author wrsstart
 * @creat 2021-03-08 18:29
 */
public interface ReturnListGoodsService {
    ServiceVO save(String returnListGoodsStr, Integer returnListId);
}
