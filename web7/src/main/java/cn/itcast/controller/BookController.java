package cn.itcast.controller;

import cn.itcast.model.Book;
import cn.itcast.service.BookService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :BookController
 * @time :2019.08.28,11:12
 * @file :cn.itcast.controller.BookController.jave
 */
@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @RequestMapping(value = "/addbook")
    public String index() {
        return "book/addbook";
    }

    @RequestMapping(value = "/doAddBook")
    public String doaddBook(Book book) {

        Integer integer = bookService.saveObject(book);
        System.out.println(integer);
        System.out.println(book);
        return "redirect:/book/addbook";
    }

    @RequestMapping(value = "/list")
    public String booklist() {
        return "book/booklist";
    }

    /**
     * booklist查询，返回json数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/doBookList")
    public String doBookList() {
        List all = bookService.findAll();
        return JSON.toJSONString(all).trim();
    }
}
