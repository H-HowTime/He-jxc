package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author huima9527
 * @create 2021-03-08 14:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class purchaseListGoodsImplTest {
    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    @Test
    public void orderInquity() {
        Map<String, List<PurchaseList>> map = this.purchaseListGoodsService.OrderInquity("", 1, 1, "2019-08-03", "2021-10-10");
        System.out.println(map);
    }
}