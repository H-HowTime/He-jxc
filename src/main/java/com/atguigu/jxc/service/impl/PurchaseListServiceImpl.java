package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListDao;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.User;
import com.atguigu.jxc.service.PurchaseListService;
import com.google.gson.Gson;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * @author wrsstart
 * @creat 2021-03-08 14:36
 */
@Service
@Transactional
public class PurchaseListServiceImpl implements PurchaseListService {

    @Autowired
    private PurchaseListDao purchaseListDao;


    @Override
    public int save(PurchaseList purchaseList, String purchaseNumber, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        Integer userId = user.getUserId();
        purchaseList.setPurchaseNumber(purchaseNumber);
        purchaseList.setUserId(userId);
        int purchaseListId = this.purchaseListDao.save(purchaseList);
        return purchaseListId;
    }
}
