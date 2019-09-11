package cn.itcast.test;

import cn.itcast.exceptions.QueryException;
import cn.itcast.model.FileList;
import cn.itcast.service.FileListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListserviceTest
 * @time :2019.08.26,13:11
 * @file :cn.itcast.test.FileListserviceTest.jave
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileListserviceTest {

    @Autowired
    @Qualifier("fileListService")
    private FileListService fileListService;

    @Test
    public void findFileListAllTest() {
        List<FileList> all = fileListService.findFileListAll();
        System.out.println(all);
    }

    @Test
    public void PagesTest() throws QueryException {

        List<FileList> page = fileListService.findFileListPage(10, 9);
        System.out.println(page);
        System.out.println(page.size());

        List<FileList> firstPage = fileListService.findFileListFirstPage();
        System.out.println(firstPage);
        System.out.println(firstPage.size());

        List<FileList> lastPage = fileListService.findFileListLastPage();
        System.out.println(lastPage);
        System.out.println(lastPage.size());

        List<FileList> listPage = fileListService.findFileListPage(9);
        System.out.println(listPage);
        System.out.println(listPage.size());

        List<FileList> lastPage1 = fileListService.findFileListLastPage(10);
        System.out.println(lastPage1);
        System.out.println(lastPage1.size());

        List<FileList> firstPage1 = fileListService.findFileListFirstPage(10);
        System.out.println(firstPage1);
        System.out.println(firstPage1.size());
    }

    @Test
    public void saveTest() throws QueryException {
        FileList fileList = new FileList();

        fileList.setName("ceshi");
        fileList.setUrl("http://www.ceshi.com");
        Integer id = fileListService.save(fileList);
        System.out.println(id);

        List<FileList> page = fileListService.findFileListPage(5, 0);
        Integer list = fileListService.saveBatch(page);
        System.out.println(list);
    }

}
