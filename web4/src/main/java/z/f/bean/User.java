package z.f.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * codening:utf-8
 *
 * @author :User
 * @time :2019.08.14,22:29
 * @file :z.f.bean.User.jave
 */

@Getter
@Setter
@ToString
public class User implements Serializable {
    private Integer userid;
    private Integer userres;
    private String username;
    private String userpassword;
}
