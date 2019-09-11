package cn.itcast.controller;

import cn.itcast.model.User;
import cn.itcast.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :UserController
 * @time :2019.08.22,22:30
 * @file :cn.itcast.controller.UserController.jave
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(path = "/user")
    public String index(Map<String, Object> map) {
        List<User> all = userService.findUserAll();
        System.out.println("user index run ...");
        map.put("messages", "springboot thymeleaf run ... ok");
        map.put("data", all);
        return "user";
    }

    /**
     * 表单测试
     *
     * @author z
     */
    @RequestMapping(value = "/from")
    @ResponseBody
    public Object from(String name, String password) {
        System.out.println(name);
        User user = new User();
        if (name != null) {
            user = userService.findUserByName(name);
        }
        if (password != null) {
            user = userService.findUserByName(password);
        }
        System.out.println(user);
        List<User> all = userService.findUserAll();
        Map<String, Object> map = new HashMap<>(5);
        map.put("user", user);
        map.put("list", all);

        return JSON.toJSONString(map).trim();
    }

    /**
     * 文件下载测试
     *
     * @author z
     */
    @RequestMapping(value = "/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = "D:\\毕业照片\\视频\\电影\\宠物坟场.mkv";
        String[] split = path.split("\\\\");
        String fileName = split[split.length - 1];
        FileInputStream fileInputStream = new FileInputStream(path);

        OutputStream outputStream = response.getOutputStream();
        //向客户端发送下载头
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        byte[] bytes = new byte[1024 * 1000];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
            outputStream.flush();
        }
    }

    @RequestMapping(path = "/index")
    @ResponseBody
    public String catalog() {
        return "index";
    }

}
