package z.f.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * codening:utf-8
 *
 * @author :User
 * @time :2019.08.12,17:04
 * @file :z.f.bean.User.jave
 */
@Component
@ConfigurationProperties(prefix = "user")
@Getter@Setter@ToString
public class UserText {
    private String username;
    private Integer age;
    private Date date;

    private List<Object> list;
    private Map<String,Object> map;

    private FileList fileList;
}
