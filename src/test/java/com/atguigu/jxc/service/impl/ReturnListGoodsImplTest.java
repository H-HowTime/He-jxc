package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.service.ReturnListGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author huima9527
 * @create 2021-03-08 17:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReturnListGoodsImplTest {

    @Autowired
    private ReturnListGoodsService returnListGoodsService;

    @Test
    public void salesReturn() {
        Map<String, Object> map = this.returnListGoodsService.salesReturn("99", 1, 2, "2019-01-03", "2020-10-10");
        System.out.println(map);

    }

    @Test
    public void salesReturnNews(){
        Map<String, Object> map = this.returnListGoodsService.salesReturnNews(134);
        System.out.println(map);
    }
}