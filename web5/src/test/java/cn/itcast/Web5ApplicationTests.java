package cn.itcast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Web5ApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {

        logger.trace("this is trace run ...");
        logger.debug("this is debug run ...");
        //this is default
        logger.info("this is info run ...");
        logger.warn("this is warn run ...");
        logger.error("this is error run ...");
    }

}
