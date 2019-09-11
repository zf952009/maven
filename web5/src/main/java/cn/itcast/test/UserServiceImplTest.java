package cn.itcast.test;

import cn.itcast.exception.UserException;
import cn.itcast.model.User;
import cn.itcast.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * codening:utf-8
 * userServiceImpl 测试
 *
 * @author :UserServiceImplTest
 * @time :2019.08.15,0:34
 * @file :cn.itcast.test.UserServiceImplTest.jave
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void setUserServiceGetUserAllTest() {
        List<User> all = userService.findUserAll();
        System.out.println(all);
    }

    @Test
    public void UserServiceFindUserByID() {
        User user = userService.findUserByID(2);
        System.out.println(user);
    }

    @Test
    public void UserServiceFindUserByName() {
        User user = userService.findUserByName("邹芳1");
        System.out.println(user);
    }

    @Test
    public void UserServiceInsertUserOne() {
        User user = new User();
        user.setUsername("邹芳1");
        user.setUserpassword("e10adc3949ba59abbe56e057f20f883e");
        Integer integer = null;
        try {
            integer = userService.insertUserOne(user);
        } catch (UserException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }

    @Test
    public void UserServiceFindUserByObject() {
        User user = new User();

        user.setUsername("");
        user.setUserid(2);
        List<User> users = userService.findUserByObject(user);
        System.out.println(users);
    }

    @Test
    public void UserServiceInsertUserBatchTest(){
        List<User> list = new ArrayList<>();

        User user = new User();
        user.setUsername("user");
        user.setUserpassword("e10adc3949ba59abbe56e057f20f883e");
        User user1 = new User();
        user1.setUsername("usertest");
        user1.setUserpassword("e10adc3949ba59abbe56e057f20f883e");
        try {
            userService.insertUserBatch(list);
        } catch (UserException e) {
            e.printStackTrace();
        }

    }

}
