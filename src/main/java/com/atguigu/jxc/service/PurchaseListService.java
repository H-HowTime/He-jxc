package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.PurchaseList;

import javax.servlet.http.HttpSession;

/**
 * @author wrsstart
 * @creat 2021-03-08 14:35
 */
public interface PurchaseListService {

    int save(PurchaseList purchaseList, String purchaseNumber, HttpSession session);
}
