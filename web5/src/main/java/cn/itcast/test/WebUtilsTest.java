package cn.itcast.test;

import cn.itcast.util.StringUtils;
import org.junit.Test;

/**
 * codening:utf-8
 *
 * @author :WebUtilsTest
 * @time :2019.08.24,21:59
 * @file :cn.itcast.test.WebUtilsTest.jave
 */
public class WebUtilsTest {

    @Test
    public void md5Test(){
        String[] strings = StringUtils.tokenizeToStringArray("1  2 3 4    5     6", " ");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        boolean b = StringUtils.hasText("122");
        System.out.println(b);

        String s = StringUtils.trimAllWhitespace("  121 2 121 2 \n    ");
        System.out.println(s);
        System.out.println(StringUtils.trimWhitespace("    444 1  4    \n"));
        System.out.println("    444 1  4    \n");
    }
}
