package cn.itcast.dto;

import cn.itcast.dataobject.OrderDetail;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * codening:utf-8
 *
 * @author :OrderDTO
 * @time :2019.09.06,19:30
 * @file :cn.itcast.dto.OrderDTO.jave
 */
@Getter
@Setter
@ToString
public class OrderDTO {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 买家名字
     */
    private String buyerName;
    /**
     * 买家手机号
     */
    private String buyerPhone;
    /**
     * 地址
     */
    private String buyerAddress;
    /**
     * 微信的openID
     */
    private String buyerOpenid;
    /**
     * 订单总额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认新下单
     */
    private Integer orderStatus;
    /**
     * 支付状态，默认等待
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
