package cn.itcast.test;

import cn.itcast.model.User;
import cn.itcast.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserServiceTest
 * @time :2019.08.25,14:28
 * @file :cn.itcast.test.UserServiceTest.jave
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Test
    public void getUserAllTest() {
        List<User> all = userService.findUserAll();
        System.out.println(all);
    }

    @Test
    public void finUserByUserName() {
        User user = userService.findUserByName("邹芳");
        System.out.println(user);

    }
}
