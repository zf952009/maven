package cn.itcast.test.spring;

import cn.itcast.model.spring.User;
import cn.itcast.service.spring.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserServiceTest
 * @time :2019.08.20,14:32
 * @file :cn.itcast.test.mapper.UserServiceTest.jave
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserServiceTest {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Test
    public void selectUserAllTest() {
        List<User> list = userService.selectUserAll();
        System.out.println(list);
    }

    @Test
    public void getUserByIDTest() {
        User user = userService.getUserByID(1);
        System.out.println(user);
    }

    @Test
    public void getUserByIDAndFileListTest() {
        List<User> list = userService.getUserByIDAndFileList();
        System.out.println(list.size());
    }

    @Test
    public void discriminatorByIDTest() {
        User user = userService.discriminatorByIDTest(2);
        System.out.println(user);

    }
}
