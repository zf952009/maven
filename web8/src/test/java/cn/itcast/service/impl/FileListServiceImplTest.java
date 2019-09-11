package cn.itcast.service.impl;

import cn.itcast.domain.FileList;
import cn.itcast.service.FileListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileListServiceImplTest {

    @Autowired
    private FileListService fileListService;

    @Test
    public void findById() {
        FileList fileList = fileListService.getById(1);
        System.out.println(fileList);
    }
}