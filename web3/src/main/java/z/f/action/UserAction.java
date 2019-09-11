package z.f.action;

import com.opensymphony.xwork2.ActionSupport;
import z.f.bean.User;
import z.f.service.UserService;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserAction
 * @time :2019.08.11,12:14
 * @file :z.f.action.UserAction.jave
 */
public class UserAction extends ActionSupport {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String index(){
        List<User> all = userService.getUserAll();
        System.out.println(all);
        System.out.println("strut run ...");
        return SUCCESS;
    }
}
