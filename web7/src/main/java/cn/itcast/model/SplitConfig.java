package cn.itcast.model;

import cn.itcast.util.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * 碎片文件配置对象
 * codening:utf-8
 *
 * @author :SplitConfig
 * @time :2019.07.08,10:55
 * @file :in.itcast.domain.SplitConfig.jave
 */
public class SplitConfig implements Serializable {
    private String splittype;
    private String filepath;
    private String filename;
    private Integer filacount;
    private Integer buffer_size;

    public SplitConfig(String splittype, String filepath, String filename, Integer filacount, Integer buffer_size) {
        this.splittype = splittype;
        this.filepath = filepath;
        this.filename = filename;
        this.filacount = filacount;
        this.buffer_size = buffer_size;
    }

    public Map<String, String> getConfig() {
        Map<String, String> map = new LinkedHashMap<>();
        if (this.buffer_size != null) {
            map.put("buffer_size", buffer_size.toString());
        } else {
            //默认缓冲区大小
            map.put("buffer_size", FileUtil.BUFFER_SIZE.toString());
        }
        if (this.filacount != null) {
            map.put("filecount", this.filacount.toString());
        } else {
            map.put("filecount", "0");
        }
        if (this.filename != null || !"".equals(this.filename)) {
            map.put("filename", this.filename);
        } else {
            map.put("filename", "");
        }
        if (this.filepath != null || !"".equals(this.filepath)) {
            map.put("filepath", this.filepath);
        } else {
            map.put("filepath", "");
        }
        if (this.splittype != null || !"".equals(this.splittype)) {
            map.put("splittype", this.splittype);
        } else {
            map.put("splittype", "");
        }
        return map;
    }

    public String ConfigWriter(File file) throws IOException {
        Map<String, String> config = this.getConfig();
        Properties properties = new Properties();
        Iterator<String> iterator = config.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = config.get(key);
            properties.setProperty(key, value);
        }
        properties.store(new FileWriter(file), filename + " config");
        properties.clone();
        return file.getAbsolutePath();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SplitConfig)) {
            return false;
        }
        SplitConfig that = (SplitConfig) o;
        return Objects.equals(splittype, that.splittype) &&
                Objects.equals(filepath, that.filepath) &&
                Objects.equals(filename, that.filename) &&
                Objects.equals(filacount, that.filacount) &&
                Objects.equals(buffer_size, that.buffer_size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(splittype, filepath, filename, filacount, buffer_size);
    }
}
