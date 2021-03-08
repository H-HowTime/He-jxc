package com.atguigu.jxc.domain;

import lombok.Data;

/**
 * @author hehao
 * @create 2021-03-08 16:55
 */
@Data
public class SaleDataDayVo {
    private String date;//销售日期
    private String purchaseDate;//购买日期
    private Double saleTotal;//销售总金额
    private Double purchasingTotal;//成本总金额
    private Double profit;//盈利总金额
}
