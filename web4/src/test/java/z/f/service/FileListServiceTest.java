package z.f.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import z.f.bean.FileList;
import z.f.util.FileUtil;
import z.f.util.SystemUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListServiceTest
 * @time :2019.08.14,8:22
 * @file :z.f.service.FileListServiceTest.jave
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileListServiceTest {

    @Autowired
    private FileListService fileListService;

    @Test
    public void getFileListServiceGetAllTest() {
        List<FileList> all = fileListService.getFileListAll();
        System.out.println(all.size());
    }

    @Test
    public void findFileListServiceNameTest() {
        List<FileList> list = fileListService.findFileListBYName("jsp");
        System.out.println(list);
    }

    @Test
    public void findFileListBYIDTest() {
        FileList fileList = fileListService.findFileListBYID(1);
        System.out.println(fileList);
    }

    @Test
    public void findFileListByIDandNameTest() {
        FileList filelist = fileListService.findFileListByIDandName(12, "jsp");
        System.out.println(filelist);

    }

    @Test
    public void getFileListByNameTest() {
        FileList fileList = fileListService.getFileListByName("");
        System.out.println(fileList);
    }

    @Test
    public void findFileListPagesTest() {
        List<FileList> pages = fileListService.findFileListPages(1, 6);
        System.out.println(pages);
    }

    @Test
    public void FileListToMd() {
        List<FileList> all = fileListService.getFileListAll();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < all.size(); i++) {
            FileList fileList = all.get(i);
            String name = fileList.getName().trim();

            String url = fileList.getUrl();
            stringBuilder.append("###### `" + name + "`" + SystemUtils.LINE_SEPARATOR + "(" + url + ")" + SystemUtils.LINE_SEPARATOR);
            if (i % 30 == 0) {
                stringBuilder.append("---" + SystemUtils.LINE_SEPARATOR);
            }
        }
        FileUtil.StringToMd(stringBuilder.toString(), "", "fileLie.md");
    }

    @Test
    public void insertFileListOneTest() {
        FileList fileList = new FileList();
        fileList.setName("springbot fileList username test");
        fileList.setUrl("http://springbot fileList username test");
        Integer integer = fileListService.insertFileListOne(fileList);
        System.out.println(integer);
    }

    @Test
    public void inserFileListListTest() {
        LinkedList<FileList> linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            FileList fileList = new FileList();
            fileList.setName("springbot fileList username test" + i);
            fileList.setUrl("http://springbot fileList username test" + i);
            linkedList.addLast(fileList);
        }
        List<Integer> integers = fileListService.insertFileListList(linkedList);
        System.out.println(integers);

    }
}
