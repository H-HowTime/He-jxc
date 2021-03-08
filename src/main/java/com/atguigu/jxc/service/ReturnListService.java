package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.ReturnList;

import javax.servlet.http.HttpSession;

/**
 * @author wrsstart
 * @creat 2021-03-08 18:23
 */
public interface ReturnListService {
    void save(ReturnList returnList, HttpSession session);
}
