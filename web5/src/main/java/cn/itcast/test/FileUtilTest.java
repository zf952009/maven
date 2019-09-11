package cn.itcast.test;

import cn.itcast.util.FileUtil;
import cn.itcast.util.WebUtils;
import org.junit.Test;

/**
 * codening:utf-8
 *
 * @author :FileUtilTest
 * @time :2019.08.24,10:27
 * @file :cn.itcast.test.FileUtilTest.jave
 */
public class FileUtilTest {


    @Test
    public void getFileTypeTest() {
        String path = "C:\\user\\ideaProject\\DemoStruts2\\src\\in\\itcast\\domain\\Media.java";
        String type = FileUtil.getFileType(path);
        System.out.println(type);
        System.out.println(FileUtil.subFileName(path));
        System.out.println(FileUtil.getSuffix(path));

        System.out.println(FileUtil.subFileName("D:\\毕业照片\\视频\\电影\\宠物坟场.mkv"));
    }

    @Test
    public void toKenTest() {
        String token = WebUtils.token(9);
        System.out.println(token);
    }
}
