package cn.itcast.util;

/**
 * codening:utf-8
 *
 * @author :FileUtil
 * @time :2019.08.05,13:43
 * @file :cn.itcast.util.FileUtil.jave
 */

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 * 文件工具类
 *
 * @author user
 */
public class FileUtil {
    /**
     * 字符串输出到文件
     *
     * @param string   待写字符串
     * @param fileName 文件名
     * @param path     输出路径
     */
    public static void StringToFileTxT(String string, String CHARSET, String fileName, File path) {
        //没有指定编码，使用系统默认编码
        if (CHARSET == null || CHARSET == "") {
            CHARSET = SystemUtils.CHARSET;
        }
        if (!path.exists()) {
            path.mkdirs();
        }
        File file = new File(path, fileName);
        OutputStreamWriter writer = null;
        //判断是否为目录
        try {
            if (!file.isDirectory()) {
                FileOutputStream fileOutputStream = null;
                fileOutputStream = new FileOutputStream(file, true);
                writer = new OutputStreamWriter(fileOutputStream, CHARSET);
            } else {
                //非目录
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String dateTime = DateUtil.getFormarDateTime(simpleDateFormat);
                File file1 = new File(path, dateTime + ".md");
                FileOutputStream fileOutputStream = new FileOutputStream(file1, true);
                writer = new OutputStreamWriter(fileOutputStream, CHARSET);
            }
            writer.write(string + SystemUtils.LINE_SEPARATOR);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 跨服器文件上传
     *
     * @param file
     * @param path
     */
    public static void saveSpringMVCFileServlet(MultipartFile file, String path) {
        if (path == null) {
            throw new RuntimeException("path not null");
        }

    }

    /**
     * springMVC 文件上传
     *
     * @param file    文件解析器对象
     * @param dir     文件保存路径
     * @param request 服务器响应对象
     * @return 上传文件的全路径，(文件夹+文件名)
     */
    public static String saveSpringMVCFile(MultipartFile file, HttpServletRequest request, String dir) {
        if (dir == null) {
            dir = "\\file\\";
        }
        String path = request.getSession().getServletContext().getRealPath("\\download\\");
        //文件名获取
        String fileName = file.getOriginalFilename();
        File fileTemp = new File(path, fileName);
        /**
         * 测试文件是否存在，存在就重命名，不存在就按照源文件保存
         * */
        if (fileTemp.exists()) {
            String format = DateUtil.getFormarDateTime();
            File fileUp = new File(path, format + fileName);
            try {
                file.transferTo(fileUp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                file.transferTo(fileTemp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return fileTemp.getAbsolutePath();
    }
}
