package cn.itcast.model.spring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * codening:utf-8
 *
 * @author :FileList
 * @time :2019.08.20,15:20
 * @file :cn.itcast.model.spring.FileList.jave
 * @alias mybatis对象别名
 */
@Getter
@Setter
@ToString
@Alias("fileList")
public class FileList {
    private Integer id;
    private String name;
    private String url;
    private String type;
    private String status;
    private String create_time;
    private String update_time;
    private Integer user_id;
    private User user;
}
