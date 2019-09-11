package cn.itcast.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * codening:utf-8
 *
 * @author :FileList
 * @time :2019.08.20,15:20
 * @file :cn.itcast.model.FileList.jave
 * @alias mybatis对象别名
 */
@Getter
@Setter
@ToString
public class FileList implements Serializable {

    private Integer id;

    private String name;
    private String url;
    private String type;
    private String status;
    private String create_time;
    private String update_time;
    private Integer user_id;
}
