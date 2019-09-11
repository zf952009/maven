package c.z.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileList
 * @time :2019.08.11,23:29
 * @file :c.z.bean.FileList.jave
 */
@Getter@Setter@ToString
public class FileList implements Serializable {
    private Integer id;
    private Integer res;
    private Integer type;
    private String name;
    private String url;
    private List<User> list;
}
