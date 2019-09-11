package cn.itcast.service;

/**
 * @author z
 */
public interface MailService {


    /**
     * 简单的邮件发送
     *
     * @param to      邮件接受者
     * @param subject 邮件主题
     * @param content 邮件的主体内容
     * @author z
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送html格式的邮件
     *
     * @param to      邮件接受者
     * @param subject 邮件主题
     * @param content 邮件的主体内容
     * @author z
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带有附件的邮件
     *
     * @param to       邮件接受者
     * @param subject  邮件主题
     * @param content  邮件的主体内容
     * @param filePath 附件路径
     * @author z
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送静态资源邮件，一般指图片
     *
     * @param to          邮件接受者
     * @param subject     邮件主题
     * @param content     邮件的主体内容
     * @param resourePath 静态资源路径
     * @author z
     */
    void sendInlineResourceMail(String to, String subject, String content, String resourcePath);
}
