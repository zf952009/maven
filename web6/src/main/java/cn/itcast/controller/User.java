package cn.itcast.controller;

import cn.itcast.service.spring.UserService;
import cn.itcast.util.DateUtil;
import cn.itcast.util.FileUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :User
 * @time :2019.08.20,13:43
 * @file :cn.itcast.controller.User.jave
 */
@Controller
@RequestMapping(path = "/user")
public class User {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/index")
    public Object index() {
        List<cn.itcast.model.spring.User> list = userService.selectUserAll();
        System.out.println(list);
        System.out.println("springmvc web6 run ...");

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "ok");
        map.put("data", list);
        return JSON.toJSONString(map).trim();
    }

    /**
     * 文件上传
     *
     * @author z
     */
    @RequestMapping(value = "/fileUP")
    public Object fileUp(HttpServletRequest request, ModelAndView modelAndView) {
        System.out.println("fileUP run...");
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        String filePath = "";
        try {
            List<FileItem> parseRequest = servletFileUpload
                    .parseRequest(request);
            for (int i = 0; i < parseRequest.size(); i++) {
                FileItem fileItem = parseRequest.get(i);
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("utf-8");
                    System.out
                            .println("---------------------------普通表单信息列表---------------------------");
                    System.out.println("name:" + name);
                    System.out.println("value:" + value);
                } else {
                    System.out
                            .println("---------------------------文件信息列表---------------------------");
                    String fieldName = fileItem.getName();
                    long size = fileItem.getSize();
                    String type = fileItem.getContentType();
                    System.out.println("fileName :" + fieldName);
                    System.out.println("size: " + size);
                    System.out.println("type:" + type);
                    //文件保存路径
                    String path = request.getSession().getServletContext().getRealPath("\\download\\");
                    //测试文件夹是否存在
                    File dir = new File(path);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    File file = new File(path, fieldName);
                    /**
                     * 测试文件是否存在，存在就重命名，不存在就按照源文件保存
                     * */
                    if (file.exists()) {
                        String format = DateUtil.getFormarDateTime();
                        File fileUp = new File(path, format + fieldName);
                        System.out.println(format);
                        System.out.println(path);
                        fileItem.write(fileUp);
                    } else {
                        fileItem.write(file);
                    }
                    fileItem.delete();
                    filePath = file.getAbsolutePath();
                    System.out.println(file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        modelAndView.addObject("message", "fileUP run ok ... filePath:" + filePath);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    /**
     * 使用springmvc上传文件
     * 需要在spring-mvc.xml核心配置中配置文件解析器对象(必须)
     * <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
     *
     * @author z
     */
    @RequestMapping(value = "/springMVCFileUP")
    public Object springMVCFileUP(@RequestParam(value = "file", required = false) MultipartFile file, ModelAndView modelAndView, HttpServletRequest request) {
        System.out.println("springMVC 文件上传...");
        String filePath = FileUtil.saveSpringMVCFile(file, request, "\\download\\");
        modelAndView.setViewName("success");
        modelAndView.addObject("message", "fileUP run ok ... filePath:" + filePath);
        return modelAndView;
    }

    /**
     * 仅用于测试转发和重定向
     * c
     *
     * @author z
     * 使用forward:请求转发
     * return "forward:/start/html/index.html";-->return "forward:页面全路径";转发到指定的页面
     * return "forward:/user/index";-->return "forward:控制器全映射";转发到指定的controller
     * <p>
     * 使用redirect:请求重定向
     * return "redirect:/start/html/index.html";-->return "forward:页面全路径";重定向指定的页面
     * return "redirect:/user/index";-->return "forward:控制器全映射";重定向到指定的controller
     */
    @RequestMapping(value = "/toIndex")
    public Object toIndex() {
        return "redirect:/user/index";
    }

}
