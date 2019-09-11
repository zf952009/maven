package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * codening:utf-8
 *
 * @author :AdminController
 * @time :2019.08.21,16:16
 * @file :cn.itcast.controller.AdminController.jave
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {


    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(){

        return "index";
    }
}
