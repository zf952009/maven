package z.f.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import z.f.bean.FileList;
import z.f.bean.UserText;
import z.f.service.FileListService;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserController
 * @time :2019.08.12,13:15
 * @file :z.f.controller.UserController.jave
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserText user;

    @Autowired
    private FileListService fileListService;

    @RequestMapping(path = "/index")
    @ResponseBody
    public UserText index() {
        System.out.println("springBoot run ...");
        return user;
    }

    @RequestMapping(path = "/index/html")
    @ResponseBody
    public Object index1() {
        List<FileList> all = fileListService.getFileListAll();
        return all;
    }

    @RequestMapping(path = "/toIndexJSP")
    public String toIndexJSP(Model model) {
        List<FileList> all = fileListService.getFileListAll();
        model.addAttribute("mes", all);
        System.out.println("toIndexJSON run...");
        return "index";
    }

    /**
     * id 查询测试
     *
     * @author z
     */
    @RequestMapping(path = "/toIndexHtml/id/{id}")
    @ResponseBody
    public FileList toIndexHtmlGetID(@PathVariable("id") Integer id) {
        FileList fileList = fileListService.findFileListBYID(id);
        return fileList;
    }

    /**
     * name查询测试
     *
     * @author z
     */
    @RequestMapping(path = "/toIndexHtml/name/{name}")
    @ResponseBody
    public List toIndexHtmlFindName(@PathVariable("name") String name) {
        List<FileList> list = fileListService.findFileListBYName(name);
        System.out.println(name);

        return list;
    }

    @RequestMapping(path = "/toIndexJSP/{id}/{name}")
    public String toIndexJSP(@PathVariable("id") Integer id, @PathVariable("name") String name, Model model) {
        List<FileList> fileList = fileListService.findFileListBYIDorNname(name, id);
        model.addAttribute("mes", fileList);
        return "index";
    }

    @RequestMapping(path = "/toIndexJSP/name/{name}")
    public String toIndexJSP(@PathVariable("name") String name, Model model) {
        List<FileList> list = fileListService.findFileListBYName(name);
        model.addAttribute("mes", list);
        return "index";
    }
}
