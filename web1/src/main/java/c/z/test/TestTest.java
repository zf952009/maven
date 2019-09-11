package c.z.test;

import org.junit.Test;

/**
 * codening:utf-8
 *
 * @author :TestTest
 * @time :2019.08.12,13:35
 * @file :c.z.test.TestTest.jave
 */
public class TestTest {

    @Test
    public void test() {
        StringBuilder stringBuilder = new StringBuilder().append("you-get ");
        for (int i = 1; i <= 203; i++) {
            stringBuilder.append("https://www.bilibili.com/video/av33884807/?p=" + i + " ");
        }
        System.out.println(stringBuilder.toString());
    }
}
