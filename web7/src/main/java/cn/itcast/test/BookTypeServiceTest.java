package cn.itcast.test;

import cn.itcast.model.BookType;
import cn.itcast.service.BookTypeService;
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
 * @author :BookTypeService
 * @time :2019.08.28,14:25
 * @file :cn.itcast.test.BookTypeService.jave
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTypeServiceTest {

    @Autowired
    @Qualifier("bookTypeService")
    private BookTypeService bookTypeService;

    @Test
    public void findAllTest() {
        List all = bookTypeService.findAll();
        System.out.println(all);

        BookType bookType = bookTypeService.findByID(1);
        System.out.println(bookType);
    }

    @Test
    public void saveObjectTest() {
        BookType bookType = new BookType();
        bookType.setName("测试类型");
        Integer integer = bookTypeService.saveObject(bookType);
        System.out.println(integer);

    }
}
