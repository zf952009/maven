package cn.itcast.test;

import cn.itcast.model.Book;
import cn.itcast.model.BookType;
import cn.itcast.model.User;
import cn.itcast.service.BookService;
import cn.itcast.service.BookTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :BookServiceTest
 * @time :2019.08.28,14:01
 * @file :cn.itcast.test.BookServiceTest.jave
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @Qualifier("bookTypeService")
    @Autowired
    private BookTypeService bookTypeService;

    Logger logger = LoggerFactory.getLogger(this.getClass());



    @Test
    public void selectOneTest(){
        User user = new User();
        user.setUserid(1);
    }

    @Test
    public void findAll() {
        List<Book> all = bookService.findAll();
        System.out.println(all);
        Integer typeid = all.get(1).getTypeid();
        BookType byID = bookTypeService.findByID(typeid);
        all.get(1).setBookType(byID);
        System.out.println(all);
        logger.info(String.valueOf(all));
        Book book = bookService.findByID(3);
        System.out.println(book);
    }

    @Test
    public void findByName() {
        List<Book> list = bookService.findByName("%测试%");
        System.out.println(list);
    }

    @Test
    public void saveObjectTest() {
        Book book = new Book();
        book.setBookdescription("测试书籍简介");
        book.setBookname("测试书名");
        book.setBooknumber(1);
        book.setPress("测试出版社");

        Integer integer = bookService.saveObject(book);
        System.out.println(integer);
    }

    @Test
    public void countTest() {
        Integer count = bookService.count();
        System.out.println(count);
    }
}
