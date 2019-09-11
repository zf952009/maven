package cn.itcast.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 数据表book_type对应的实体对象
 * codening:utf-8
 * CREATE TABLE `book_type`(
 * `id` int not null auto_increment,
 * `name` varchar(64) not null comment '类别名',
 * `create_time` timestamp not null default current_timestamp comment '创建时间',
 * `updata_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
 * primary key(`id`)
 * );
 *
 * @author :BookType
 * @time :2019.08.28,13:54
 * @file :cn.itcast.model.BookType.jave
 */

@Getter
@Setter
@ToString
public class BookType {
    private Integer id;
    private String name;
    private String status;
    private String createtime;
    private String updatetime;
    private List<Book> bookList;
}
