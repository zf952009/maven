package cn.itcast.service.impl;

import cn.itcast.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * codening:utf-8
 *
 * @author :MailServiceImpl
 * @time :2019.08.26,14:39
 * @file :cn.itcast.service.impl.MailServiceImpl.jave
 */
@Service("mailService")
@Transactional
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;


    @Value("${spring.mail.username}")
    private String send;


    /**
     * 简单的邮件发送
     *
     * @param to      邮件接受者
     * @param subject 邮件主题
     * @param content 邮件的主体内容
     * @author z
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom(send);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try {

            mailSender.send(simpleMailMessage);
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("邮件发送失败");
        }
    }

    /**
     * 发送html格式的邮件
     *
     * @param to      邮件接受者
     * @param subject 邮件主题
     * @param content 邮件的主体内容
     * @author z
     */
    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = messageHelper(message, to, subject, content);
            mailSender.send(message);
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("邮件发送失败");
        }
    }

    /**
     * 发送带有附件的邮件
     *
     * @param to       邮件接受者
     * @param subject  邮件主题
     * @param content  邮件的主体内容
     * @param filePath 附件路径
     * @author z
     */
    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = messageHelper(message, to, subject, content);
            FileSystemResource resource = new FileSystemResource(new File(filePath));
            String filename = resource.getFilename();
            messageHelper.addAttachment(filename, resource);
            mailSender.send(message);
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("邮件发送失败");
        }
    }

    /**
     * 发送静态资源邮件，一般指图片
     *
     * @param to           邮件接受者
     * @param subject      邮件主题
     * @param content      邮件的主体内容
     * @param resourcePath
     * @author z
     */
    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String resourcePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = messageHelper(message, to, subject, content);
            FileSystemResource resource = new FileSystemResource(new File(resourcePath));
            String filename = resource.getFilename();
            messageHelper.addInline(filename, resource);
            mailSender.send(message);
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("邮件发送失败");
        }
    }

    /**
     * 基本邮件信息封装
     *
     * @param to      邮件接受者
     * @param subject 邮件主题
     * @param content 邮件的主体内容
     * @author z
     */
    private MimeMessageHelper messageHelper(MimeMessage message, String to, String subject, String content) {
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(send);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);
            return messageHelper;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
