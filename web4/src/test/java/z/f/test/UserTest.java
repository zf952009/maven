package z.f.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import z.f.bean.UserText;

/**
 * codening:utf-8
 *
 * @author :UserTest
 * @time :2019.08.12,17:21
 * @file :z.f.test.UserTest.jave
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
   
    @Autowired
    private UserText user;
    @Test
    public void test(){
        System.out.println(user);
    }
}
