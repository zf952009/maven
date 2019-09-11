package cn.itcast.controller;

import cn.itcast.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :Mail
 * @time :2019.08.26,16:29
 * @file :cn.itcast.controller.Mail.jave
 */
@Controller
@RequestMapping(path = "/mail")
public class MailController {

    @RequestMapping(value = "/index")
    public String index() {
        return "mail/index";
    }

    @RequestMapping(value = "add")
    public String toAdd() {
        return "book/add";
    }

    @RequestMapping(value = "/sendMail")
    public Object sendMail(String number, String userpassword, String date, String date1, String toemail, String totheme, String tocontent, Map<String, Object> map, String sex, String[] like, String interest) {
        Mail mail = new Mail();
        System.out.println("---多选测试---");
        for (int i = 0; i < like.length; i++) {
            System.out.println(like[i]);
        }

        System.out.println("日期1:" + date);
        System.out.println("日期2:" + date1);
        System.out.println("密码框:" + userpassword);
        System.out.println("普通表单:" + number);

        System.out.println("性别:" + sex);
        System.out.println("单选测试:" + interest);
        System.out.println("收件人邮箱:" + toemail);
        System.out.println("邮件主题:" + totheme);
        System.out.println("邮件内容:" + tocontent);

        map.put("message", mail.toString());
        return "message";
    }
}
