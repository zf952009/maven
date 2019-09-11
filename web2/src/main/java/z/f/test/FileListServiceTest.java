package z.f.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import z.f.bean.FileList;
import z.f.service.FileListService;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListServiceTest
 * @time :2019.08.10,19:03
 * @file :z.f.test.FileListServiceTest.jave
 */
public class FileListServiceTest {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

    @Test
    public void GetAll(){
        FileListService fileListService = (FileListService) applicationContext.getBean("fileListService");
        List<FileList> fileListAll = fileListService.getFileListAll();
        System.out.println(fileListAll.size());
    }
}
