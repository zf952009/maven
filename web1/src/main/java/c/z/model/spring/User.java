package c.z.model.spring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * codening:utf-8
 *
 * @author :User
 * @time :2019.08.20,12:59
 * @file :c.z.model.mapper.User.jave
 */
@Getter
@Setter
@ToString
public class User {
    private Long user_id;
    private String user_name;
    private String user_password;
    private String user_type;
    private String user_status;
    private String create_time;
    private String update_time;
}
