package cn.itcast.util;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * codening:utf-8
 *
 * @author :StringToDate
 * @time :2019.08.02,17:18
 * @file :cn.itcast.util.StringToDate.jave
 */
public class StringToDate implements Converter<String, Date> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public Date convert(String source) {
        if (source == null || "".equals(source)) {
            throw new RuntimeException("source not null");
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
