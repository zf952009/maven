package cn.itcast.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * codening:utf-8
 * -- 类目
 * create table `product_category` (
 * `category_id` int not null auto_increment,
 * `category_name` varchar(64) not null comment '类目名字',
 * `category_type` int not null comment '类目编号',
 * `create_time` timestamp not null default current_timestamp comment '创建时间',
 * `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
 * primary key (`category_id`)
 * );
 *
 * @author :ProductCategory
 * @GeneratedValue(strategy = GenerationType.IDENTITY)  :主键自增由数据库维护
 * @GeneratedValue：主键默认自动生成，如果数据库设置主键自增会出现异常 com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table 'sell.hibernate_sequence' doesn't exist
 * @time :2019.09.05,21:11
 * @file :cn.itcast.dataobject.ProductCategory.jave
 */
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;

    public ProductCategory() {
    }

}
