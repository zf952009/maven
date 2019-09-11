package cn.itcast.util;

/**
 * codening:utf-8
 *
 * @author :DateUtil
 * @time :2019.08.05,13:07
 * @file :cn.itcast.util.DateUtil.jave
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author user
 */
public class DateUtil {
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss_");
    protected static SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    /**
     * 日期时间格式"yyyy_MM_dd-HH_mm_ss_"
     * 获取当前时间格式化时间字符串
     *
     * @return StringFormat
     */
    public static String getFormarDateTime() {
        return dateFormat.format(new Date());
    }

    /**
     * 日期时间格式yyyyMMddHHmmss
     * 获取当前时间格式化时间字符串
     * @param dateFormat 时间日期格式
     * @return String
     */
    public static String getFormarDateTime(SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date());
    }


}
