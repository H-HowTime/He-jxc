package com.atguigu.jxc.domain;

import lombok.Data;

/**
 * @author hehao
 * @create 2021-03-09 14:04
 */
@Data
public class SaleListGoodsVoH {
    private Integer id;//sale_list_goods_id
    private String number;//单号</th> v 根据sale_list_id去sale_list表中获取
    private Integer type;//类型</th>  v 是销售和退款等情况 根据sale_list_id去sale_list表中获取
    private String date;//日期</th> v 根据sale_list_id去sale_list表中获取
    private String customerName;//客户</th> 根据sale_list_id去sale_list表中获取customer_id,在去customer中获取
    private String code;//商品编号</th> v
    private String name;//商品名称</th> v
    private String model;//商品型号</th> v
    private String goodsType;//商品类别</th> v 根据goods_type_id去goods_type查询
    private String unit;//单位</th> v
    private double price;//单价</th> v
    private Integer num;//数量</th> v
    private double total;//总金额</th> v
}
