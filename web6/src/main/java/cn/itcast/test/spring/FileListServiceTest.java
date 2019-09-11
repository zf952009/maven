package cn.itcast.test.spring;

import cn.itcast.model.spring.FileList;
import cn.itcast.service.spring.FileListService;
import com.alibaba.fastjson.JSON;
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
 * @author :FileListServiceTest
 * @time :2019.08.20,15:37
 * @file :cn.itcast.test.spring.FileListServiceTest.jave
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class FileListServiceTest {

    @Autowired
    @Qualifier("fileListService")
    private FileListService fileListService;

    @Test
    public void selectFileListAllTest() {
        List<FileList> list = fileListService.selectFileListAll();
        System.out.println(list);
    }

    @Test
    public void selectFileListAndUserAllTest() {
        List<FileList> list = fileListService.selectFileListAndUserAll();
        System.out.println(list);
        System.out.println(JSON.toJSON(list));
    }

    @Test
    public void selectFileListAndUserAll1Test() {
        List<FileList> list = fileListService.selectFileListAndUserAll1();
        System.out.println(list);
    }

    @Test
    public void getFileListByIDTest() {
        FileList fileList = fileListService.getFileListByID(1);
        FileList fileList1 = fileListService.getFileListByID(1);
        System.out.println(fileList);
        System.out.println(fileList1);
    }

    @Test
    public void getFileListByUserIDTest() {
        List<FileList> list = fileListService.getFileListByUserID(2);
        System.out.println(list);
    }
}
