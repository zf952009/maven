package cn.itcast.controller;

import cn.itcast.exception.UserException;
import cn.itcast.model.FileList;
import cn.itcast.model.User;
import cn.itcast.service.FileListService;
import cn.itcast.service.UserService;
import cn.itcast.util.WebUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :UserController
 * @time :2019.08.25,13:49
 * @file :cn.itcast.controller.UserController.jave
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("fileListService")
    private FileListService fileListService;

    @RequestMapping(value = "/index")
    public String index(Map<String, Object> map) {
        List<User> all = userService.findUserAll();
        map.put("data", all);
        map.put("message", "邹芳就是不一样的");
        return "index";
    }

    @RequestMapping(value = "/login")
    public Object toLogin(HttpServletRequest request, ModelAndView modelAndView) {
        String userToken = WebUtils.token();
        modelAndView.setViewName("login");
        modelAndView.addObject("userToken", userToken);
        request.getSession(true).setAttribute("userToken", userToken);
        return modelAndView;
    }

    @RequestMapping(value = "/token")
    @ResponseBody
    public Object getToken(HttpServletRequest request) {
        String token = WebUtils.token();
        request.getSession(true).setAttribute("userToken", token);
        return token;
    }

    @ResponseBody
    @RequestMapping(value = "/doLogin")
    public Object doLogin(String username, @RequestParam(name = "userpassword") String password, String token, HttpServletRequest request) throws UserException {
        if (username == null || username == "") {
            return "username not null";
        }
        if (password == null || password == "") {
            return "password not null";
        }
        if (token == null || token == "") {
            return "token not null";
        }
        System.out.println(username + password + token);

        String userToken = (String) request.getSession().getAttribute("userToken");
        System.out.println(userToken);
        if (userToken == null) {
            return "userToken not null";
        }
        int length = userToken.toCharArray().length;
        if (length != 6) {
            throw new UserException(userToken + "Abnormal length ,Expected length '6'");
        }
        System.out.println(username + "----" + password + "----" + token + "----" + userToken);
        if ((Integer.valueOf(token) - Integer.valueOf(userToken)) != 0) {
            return "token error";
        }
        return username + password + token;
    }

    @RequestMapping(value = "/from")
    public Object from(Map<String, Object> map) {
        List<User> all = userService.findUserAll();
        List<FileList> all1 = fileListService.findFileListAll();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", all);
        map.put("data1", all1);
        return "form";
    }

    @RequestMapping(value = "/userlist")
    @ResponseBody
    public Object userList(String page, String limit) {
        List<User> all = userService.findUserAll();
        Map<String, Object> map = new HashMap<>(5);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", all);
        System.out.println(page + "---" + limit);

        return JSON.toJSONString(map).trim();
    }
}
