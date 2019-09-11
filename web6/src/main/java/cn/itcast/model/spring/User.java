package cn.itcast.model.spring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :User
 * @time :2019.08.20,14:14
 * @file :cn.itcast.model.mapper.User.jave
 */
@Getter
@Setter
@ToString
public class User {
    private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_type;
    private String user_status;
    private String create_time;
    private String update_time;

    List<FileList> list;
}
