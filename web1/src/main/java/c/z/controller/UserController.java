package c.z.controller;

import c.z.bean.User;
import c.z.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserController
 * @time :2019.08.10,16:09
 * @file :c.z.controller.UserController.jave
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(path = "/login")
    public String login(User user) {
        System.out.println(user);
        return "login";
    }

    @RequestMapping(path = "/ajaxTest", method = RequestMethod.POST)
    @ResponseBody
    public String getUserAll(User user) {
        List<User> all = userService.getUserAll();
        System.out.println("ajax run ...");
        System.out.println(user);
        String jsonString = JSON.toJSONString(all);
        return jsonString;
    }
}
