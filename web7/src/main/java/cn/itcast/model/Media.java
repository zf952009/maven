package cn.itcast.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * codening:utf-8
 *
 * @author :Media
 * @time :,20:53
 * @file :in.itcast.domain.Media.jave
 * 多媒体类
 */
public class Media implements Serializable {
    private static final Map<String,String> image;
    private static final Map<String,String> voide;
    private static final Map<String,String> document;
    static {
        image = new LinkedHashMap<>();
        image.put("jpg","image");
        image.put("jpeg","image");
        image.put("tif","image");
        image.put("gif","gif");
        image.put("eps","image");
        image.put("bmp","image");
        image.put("psd","psd");
        image.put("ai","ai");
        image.put("svg","svg");

        voide = new LinkedHashMap<>();
        voide.put("mp4","video");
        voide.put("avi","video");
        voide.put("mov","video");
        voide.put("rmvb","video");
        voide.put("rm","video");
        voide.put("flv","video");
        voide.put("3gp","video");
        voide.put("wmv","video");
        voide.put("asf","video");
        voide.put("mkv","video");
        voide.put("f4v","video");
        voide.put("ram","video");

        document = new LinkedHashMap<>();
        document.put("pdf","pdf");
        document.put("txt","txt");
        document.put("doc","word");
        document.put("docx","word");
        document.put("html","html");
        document.put("htm","htm");
        document.put("xml","xml");
        document.put("note","note");
        document.put("excel","excel");
        document.put("java","java");
        document.put("zip","rar");
        document.put("rar","rar");
        document.put("7z","rar");
        document.put("css","css");
        document.put("ppt","ppt");
        document.put("url","url");
        document.put("spl","spl");
        document.put("php","php");
        document.put("py","py");
        document.put("c","c");
        document.put("c++","c++");
        document.put("javascript","js");
//        document.put("jar","jar");
        document.put("tar","rar");
        document.put("ra","rar");
        document.put("z","rar");
        document.put("bz","rar");
        document.put("war","rar");
        document.put("xlsx","excel");
        document.put("xls","excel");
        document.put("pptx","pptx");
        document.put("ppt","pptx");
        document.put("sql","sql");
    }

    public static String getType(String type){
        if (type==null){
            return "unknown";
        }
        String s = image.get(type);
        String s1 = voide.get(type);
        String s2 = document.get(type);
        if (s!=null){
            return s;
        }
        if (s1!=null){
            return s1;
        }
        if (s2!=null){
            return s2;
        }
        return "unknown";
    }



}
