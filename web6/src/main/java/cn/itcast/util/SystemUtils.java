package cn.itcast.util;

import javax.swing.filechooser.FileSystemView;

/**
 * codening:utf-8
 *
 * @author :SystemUtils
 * @time :2019.08.09,11:38
 * @file :cn.itcast.util.SystemUtils.jave
 */
public class SystemUtils {
    /**
     * 系统换行符
     */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    /**
     * 获取文件编码
     */
    public static final String CHARSET = System.getProperty("file.encoding");
    /**
     * 获取当前操作系统桌面路径
     */

    public static final String DESKTOPPATH = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
}
