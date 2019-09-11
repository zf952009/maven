package cn.itcast.test;

import cn.itcast.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * codening:utf-8
 *
 * @author :MailServiceTest
 * @time :2019.08.26,14:50
 * @file :cn.itcast.test.MailServiceTest.jave
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    @Qualifier("mailService")
    private MailService mailService;

    @Test
    public void sendMailTest() {
        mailService.sendSimpleMail("13476171232@163.com", "测试主体", "邹芳就是不一样的");
    }

    @Test
    public void sendHtmlMailTest() {
        mailService.sendHtmlMail("13476171232@163.com", "这是一封html邮件", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>from</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3>这是测试邮件发送html<h3>" +
                "</body>\n" +
                "</html>");
    }

    @Test
    public void sendAttachmentsMailTest() {
        String filePath = "C:\\Users\\user\\Desktop\\GitHubJava\\md\\weblist.md";
        mailService.sendAttachmentsMail("zf9520@sina.cn", "这是一封附件测试邮件", "附件测试", filePath);
    }

    @Test
    public void sendInlineResourceMailTest() {
        String resourcePath = "C:\\Users\\user\\Desktop\\color\\支付宝收款.jpg";
        mailService.sendInlineResourceMail("13476171232@163.com", "这是一封附件测试邮件", "附件测试", resourcePath);
    }
}
