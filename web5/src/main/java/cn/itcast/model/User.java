package cn.itcast.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * codening:utf-8
 *
 * @author :User
 * @time :2019.08.15,0:14
 * @file :cn.itcast.model.User.jave
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private Integer userid;
    private String userpassword;
    private String username;
    private String usertype;
    private String userstatus;
    private String crestetime;
    private String updatetime;
}
