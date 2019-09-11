package c.z.test;

import c.z.bean.FileList;
import c.z.service.FileListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListServiceTest
 * @time :2019.08.11,23:37
 * @file :c.z.test.FileListServiceTest.jave
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class FileListServiceTest {
    @Autowired
    private FileListService fileListService;

    @Test
    public void getFileListTest() {
        List<FileList> all = fileListService.getFileListAll();
        System.out.println(all);
    }

    @Test
    public void getFileListUserAllTest() {
        List<FileList> all = fileListService.getFileListUserAll();
        int size = all.size();
        for (int i = 0; i < size; i++) {
            System.out.println(all.get(i));
        }
    }
}
