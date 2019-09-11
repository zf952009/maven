package cn.itcast.dataobject;

import cn.itcast.enums.OrderPayStatusEnums;
import cn.itcast.enums.OrderStatusEnums;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * -- 订单
 * CREATE TABLE `order_master` (
 * `order_id` VARCHAR (32) NOT NULL,
 * `buyer_name` VARCHAR (32) NOT NULL COMMENT '买家名字',
 * `buyer_phone` VARCHAR (32) NOT NULL COMMENT '买家电话',
 * `buyer_address` VARCHAR (128) NOT NULL COMMENT '买家地址',
 * `buyer_openid` VARCHAR (64) NOT NULL COMMENT '买家微信openid',
 * `order_amount` DECIMAL (8, 2) NOT NULL COMMENT '订单总金额',
 * `order_status` TINYINT (3) NOT NULL DEFAULT '0' COMMENT '订单状态, 默认为新下单',
 * `pay_status` TINYINT (3) NOT NULL DEFAULT '0' COMMENT '支付状态, 默认未支付',
 * `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
 * PRIMARY KEY (`order_id`),
 * KEY `idx_buyer_openid` (`buyer_openid`)
 * );
 * codening:utf-8
 *
 * @author :OrderMaster
 * @time :2019.09.06,12:08
 * @file :cn.itcast.dataobject.OrderMaster.jave
 */
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@Table(name = "order_master")
public class OrderMaster implements Serializable {
    @Id
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
    private Integer orderStatus = OrderStatusEnums.NEW.getCode();
    /**
     * 支付状态，默认等待
     */
    private Integer payStatus = OrderPayStatusEnums.WAIT.getCode();

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
