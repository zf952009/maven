package z.f.util;

import java.io.*;

/**
 * codening:utf-8
 *
 * @author :FileUtil
 * @time :2019.08.14,18:57
 * @file :z.f.util.FileUtil.jave
 */
public class FileUtil {
    /**
     * 文件操作工具栏
     *
     * @param text     待写字符串
     * @param fileName 文件名
     * @param path     文件路径
     * @author z
     */

    public static void StringToMd(String text, String path, String fileName) {

        if (text == null || "".equals(text)) {
            return;
        }
        if (path == null || "".equals(path)) {
            path = SystemUtils.DESKTOPPATH;
        }
        File filePath = new File(path);
        if (!filePath.isDirectory()) {
            filePath.mkdirs();
        }
        File file = new File(filePath, fileName);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(text.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
