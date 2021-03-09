package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListDao;
import com.atguigu.jxc.entity.ReturnList;
import com.atguigu.jxc.entity.User;
import com.atguigu.jxc.service.ReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * @author wrsstart
 * @creat 2021-03-08 18:23
 */
@Service
@Transactional
public class ReturnListServiceImpl implements ReturnListService {

    @Autowired
    private ReturnListDao returnListDao;

    @Override
    public void save(ReturnList returnList, HttpSession session) {

        User currentUser = (User)session.getAttribute("currentUser");
        returnList.setUserId(currentUser.getUserId());
        this.returnListDao.save(returnList);
    }
}
