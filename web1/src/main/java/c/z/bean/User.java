package c.z.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * codening:utf-8
 *
 * @author :User
 * @time :2019.08.10,15:02
 * @file :c.z.bean.User.jave
 */
@Getter@Setter@ToString
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private Integer res;
}
