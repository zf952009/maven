package c.z.test;

import c.z.bean.User;
import c.z.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserServiceTest
 * @time :2019.08.10,15:10
 * @file :c.z.test.UserServiceTest.jave
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUserAllTest() {
        List<User> userAll = userService.getUserAll();
        System.out.println(userAll);
    }

    @Test
    public void saveUserListTest() {
        userService.saveUserList(userService.getUserAll());
    }

    @Test
    public void getUserByID() {
        User user = userService.getUserByID(12);
        System.out.println(user);
    }

    @Test
    public void getUserByNameTest() {
        List<User> zoufang = userService.findUserByName("zoufang");
        System.out.println(zoufang);
    }

    @Test
    public void getUserByIDorName() {
        List<User> list = userService.findUserByIDorName(12, "zoufang");
        System.out.println(list);
    }

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setName("savezoufang");
        user.setPassword("password");
        userService.saveUser(user);
    }

    @Test
    public void updateUserTest() {
        User user = userService.getUserByID(36);
        user.setName("邹芳");
        userService.updateUser(user);
    }

    @Test
    public void deleteUserByID() {
        userService.deleteUserByID(36);
    }

    @Test
    public void deleteUserByUser() {
        User user = userService.getUserByID(35);
        userService.deleteUserByUser(user);
    }

    @Test
    public void updateBatchUserDisbledTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i, i);
        }
        userService.updateBatchUserDisbled(list);

    }

    @Test
    public void updateBatchUserStartTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(i, i);
        }
        userService.updateBatchUserStart(list);
    }

    @Test
    public void updateBatchUserTest(){
        List<User> list = userService.getUserAll();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            User user = list.get(i);
            user.setName("邹芳");
        }
        System.out.println(list);
        userService.updateBatchUser(list);
    }

    @Test
    public void getUserCountTest(){
        Integer count = userService.getUserCount();
        System.out.println(count);
    }
}
