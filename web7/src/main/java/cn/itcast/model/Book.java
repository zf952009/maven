package cn.itcast.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 数据表book对应的实体对象
 * codening:utf-8
 * CREATE table `book`(
 * `book_id` int not null auto_increment comment '书本ID',
 * `book_name` varchar(64) not null comment '书名',
 * `type_id`	int null comment '书本类型',
 * `book_description` varchar(64) comment '描述',
 * `book_status` tinyint(3) DEFAULT '0' COMMENT '书本状态,0正常1下架',
 * `create_time` timestamp not null default current_timestamp comment '创建时间',
 * `updata_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
 * PRIMARY KEY(`book_id`)
 * );
 * -- 添加字段
 * alter table `book` add `book_press` varchar(64) null ;
 * alter table `book` add `book_number` int null default 1;
 * type_id 外键--对应bookt_type的id主键
 *
 * @author :Book
 * @time :2019.08.28,11:34
 * @file :cn.itcast.model.Book.jave
 */
@Getter
@Setter
@ToString
@Alias("book")
public class Book implements Serializable {
    private Integer bookid;
    private Integer booknumber;
    private String bookauthor;
    private String bookname;
    private String press;
    private String bookstatus;
    private String createtime;
    private String updatetime;
    private String bookdescription;

    private Integer typeid;
    private BookType bookType;
}
