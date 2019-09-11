package cn.itcast.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * codening:utf-8
 * <p>
 * -- 商品
 * CREATE TABLE `product_info` (
 * `product_id` VARCHAR (32) NOT NULL,
 * `product_name` VARCHAR (64) NOT NULL COMMENT '商品名称',
 * `product_price` DECIMAL (8, 2) NOT NULL COMMENT '单价',
 * `product_stock` INT NOT NULL COMMENT '库存',
 * `product_description` VARCHAR (64) COMMENT '描述',
 * `product_icon` VARCHAR (512) COMMENT '小图',
 * `product_status` TINYINT (3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
 * `category_type` INT NOT NULL COMMENT '类目编号',
 * `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
 * PRIMARY KEY (`product_id`)
 * );
 *
 * @author :ProductInfo
 * @time :2019.09.06,0:14
 * @file :cn.itcast.dataobject.ProductInfo.jave
 */
@Entity
@Getter
@Setter
@ToString
@DynamicUpdate
@Table(name = "product_info")
public class ProductInfo implements Serializable {
    @Id
    /**
     * 商品ID，自己维护
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 小图路径
     */
    private String productIcon;

    /**
     * 商品状态，0正常1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;

}
