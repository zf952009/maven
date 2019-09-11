package cn.itcast.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * codening:utf-8
 * CREATE TABLE `order_detail` (
 * `detail_id` VARCHAR (32) NOT NULL,
 * `order_id` VARCHAR (32) NOT NULL,
 * `product_id` VARCHAR (32) NOT NULL,
 * `product_name` VARCHAR (64) NOT NULL COMMENT '商品名称',
 * `product_price` DECIMAL (8, 2) NOT NULL COMMENT '当前价格,单位分',
 * `product_quantity` INT NOT NULL COMMENT '数量',
 * `product_icon` VARCHAR (512) COMMENT '小图',
 * `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
 * PRIMARY KEY (`detail_id`),
 * KEY `idx_order_id` (`order_id`)
 * );
 *
 * @author :OrderDetail
 * @time :2019.09.06,18:24
 * @file :cn.itcast.dataobject.OrderDetail.jave
 */
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    private String detailId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    /**
     * 小图路径
     */
    private String productIcon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
