package c.z.controller;

import c.z.bean.User;
import c.z.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :ApiConreoller
 * @time :2019.08.10,14:34
 * @file :c.z.controller.ApiConreoller.jave
 */
@Controller
@RequestMapping(path = "/api")
public class ApiConreoller {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index")
    public String index(Model model) {
        System.out.println("springmvc run ...");
        List<User> userAll = userService.getUserAll();
        model.addAttribute("massage", userAll);
        System.out.println(userAll);
        return "index";
    }

    @RequestMapping(path = "/index2")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userAll = userService.getUserAll();
        modelAndView.addObject("massage", userAll);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
