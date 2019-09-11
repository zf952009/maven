package z.f.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * codening:utf-8
 *
 * @author :UserConreoller
 * @time :2019.08.10,18:21
 * @file :z.f.controller.UserConreoller.jave
 */
@Controller
@RequestMapping(path = "/user")
public class UserConreoller {

    @RequestMapping(path = "/index.html")
    public String index() {
        System.out.println("springmvc run ....");
        return "index";
    }
}
