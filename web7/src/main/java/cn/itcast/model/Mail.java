package cn.itcast.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 邮件发送信息类
 * codening:utf-8
 * <p>
 * mail 邮件地址
 * theme 邮件主题
 * text 邮件内容
 * filePath 附件路径
 * resourcesPath 静态资源路径，一般是图片资源路径
 *
 * @author :Mail
 * @time :2019.08.26,16:50
 * @file :cn.itcast.model.Mail.jave
 */
@Getter
@Setter
@ToString
public class Mail implements Serializable {
    private String mail;
    private String theme;
    private String text;
    private String filePath;
    private String resourcesPath;
}
