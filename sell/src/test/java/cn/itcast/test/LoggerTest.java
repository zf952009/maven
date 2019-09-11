package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * codening:utf-8
 *
 * @author :LoggerTest
 * @time :2019.09.05,20:32
 * @file :cn.itcast.test.LoggerTest.jave
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1() {
        String name = "user name";
        String password = "user pasword ";
        log.info("info run ..."+name);
        log.debug("debug run ...username:{}...uesrpassword:{}", name,password);
        log.error("error run ...username:{}...uesrpassword:{}", name,password);
    }
}
