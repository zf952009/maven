package cn.itcast.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * codening:utf-8
 *
 * @author :CodecTest
 * @time :2019.08.30,14:25
 * @file :cn.itcast.test.CodecTest.jave
 */
public class CodecTest {

    @Test
    public void Md5Test() {
        String md5Hex = DigestUtils.md5Hex("123456");
        System.out.println(md5Hex);

        String md5DigestAsHex = org.springframework.util.DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(md5DigestAsHex);


    }
}
