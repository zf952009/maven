package cn.itcast.util;

import cn.itcast.model.Media;
import cn.itcast.model.SplitConfig;

import java.io.*;
import java.util.*;

/**
 * 文件操作工具类
 * codening:utf-8
 *
 * @author :FileUtil
 * @time :2019.08.14,18:57
 * @file :z.f.util.FileUtil.jave
 */
public class FileUtil {

    /**
     * 定义一个1M的常量
     *
     * @author z
     */
    public static final Integer BUFFER_SIZE = 1048576;


    /**
     * 字符串写出到md文件中
     *
     * @param text     待写字符串（必须）
     * @param fileName 文件名
     * @param path     文件路径，为空时使用系统桌面文件夹
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
        String suffix = FileUtil.getSuffix(fileName);
        if (!suffix.matches("md")) {
            fileName = fileName + ".md";
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

    /**
     * 碎片文件合并
     *
     * @param properties
     * @param splitConfig
     * @throws IOException
     */
    public static void fileMerge(Properties properties, SplitConfig splitConfig) throws IOException {
        String filename = "";
        String filepath = "";
        String splittype = "";
        Integer filecount = 0;
        Integer buffer_size = BUFFER_SIZE;

        if (splitConfig != null) {
            Map<String, String> config = splitConfig.getConfig();
            filename = config.get("filename");
            filepath = config.get("filepath");
            splittype = config.get("splittype");
            filecount = Integer.parseInt(config.get("filecount"));
            buffer_size = Integer.parseInt(config.get("buffer_size"));
        }
        if (properties != null) {
            filename = properties.getProperty("filename");
            filecount = Integer.parseInt(properties.getProperty("filecount"));
            filepath = properties.getProperty("filepath");
            buffer_size = Integer.parseInt(properties.getProperty("buffer_size"));
            splittype = properties.getProperty("splittype");

        }
        //创建一个集合存储文件碎片输入流
        LinkedList<FileInputStream> list = new LinkedList<>();
        for (int i = 0; i < filecount; i++) {
            list.addLast(new FileInputStream(filepath + "\\" + i + splittype));
        }
        //缓冲区大小
        byte[] bytes = new byte[buffer_size];
        //文件输出流，文件合并后的文件存储路径
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filepath + "\\" + filename));
        for (int i = 0; i < list.size(); i++) {
            FileInputStream fileInputStream = list.get(i);
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
                fileOutputStream.flush();
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }


    /**
     * 文件切割保存
     *
     * @param file_dir 碎片保存文件夹
     * @param file_src 待切割文件
     */
    public static void fileSplit(File file_src, File file_dir) throws IOException {
        // 功能完整性判断
        // 判断源文件是否存在
        if (!(file_src.exists() && file_src.isFile())) {
            throw new RuntimeException(file_src.getName() + ":::不是正确的文件或文件不存在");
        }
        // 判断碎片文件夹是否存在,如果文件夹不存在就创建碎片文件夹
        if (!file_dir.exists()) {
            file_dir.mkdirs();
        }

        //文件名
        String filename = FileUtil.subFileName(file_src.getName());

        //文件输入流
        FileInputStream fileInputStream = new FileInputStream(file_src);
        //文件输出流
        FileOutputStream fileOutputStream = null;
        int buffer_sizee = FileUtil.BUFFER_SIZE * 20;
        byte[] bytes = new byte[buffer_sizee];
        int len = 0;
        int count = 0;
        //碎片文件保存
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream = new FileOutputStream(new File(file_dir, (count++) + ".part"));
            fileOutputStream.write(bytes, 0, len);
            fileOutputStream.flush();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    fileOutputStream.close();
                }
            }
        }

        //碎片文件配置信息保存
        SplitConfig splitConfig = new SplitConfig(".part", file_dir.getAbsolutePath(), file_src.getName(), count, buffer_sizee);
        File fileConfig = new File(file_dir, filename + ".properties");
        splitConfig.ConfigWriter(fileConfig);
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                fileInputStream.close();
            }
        }
    }

    /**
     * 文件名切割
     * 无后缀，
     *
     * @param fileName 文件路径，文件夹会返回文件夹名，文件会返回文件名
     */
    public static String subFileName(String fileName) {
        String[] split = fileName.split("\\\\");

        String s = split[split.length - 1];
        return s;
       /* StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < fileName.length(); i++) {
            char c = fileName.charAt(i);
            stringBuffer.append(c);
            if (c == '.') {
                return stringBuffer.deleteCharAt(i).toString();
            }
        }
        return fileName;*/
    }

    /**
     * 获得文件类型
     *
     * @param fileName 文件名
     */
    public static String getFileType(String fileName) {
        return Media.getType(getSuffix(fileName));
    }

    /**
     * 获取文件后缀
     *
     * @param fileName 文件名
     */
    public static String getSuffix(String fileName) {
        /**
         * 获取文件后缀，去字符串前后空白，转换成小写
         * */
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String substring = fileName.substring(fileName.lastIndexOf("."), fileName.length()).trim().toLowerCase();
            for (int i = 1; i < substring.length(); i++) {
                stringBuffer.append(substring.charAt(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "files";
        }

        return stringBuffer.toString();
    }


    /**
     * 文件复制
     *
     * @param file_dir 源文件，待复制的文件
     * @param file_src 目的文件;
     * @throws Exception
     */
    public static void FileCopy(File file_dir, File file_src) throws Exception {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        /**
         * 判断源是否为文件
         * */
        if (file_dir.isDirectory()) {
            throw new Exception("not is file");
        }
        /**
         * 获取源文件名
         * */
        if (file_src.isDirectory()) {

            file_src = new File(file_src.getAbsolutePath() + "\\copy_" + file_dir.getName());
        }
        try {
            fileInputStream = new FileInputStream(file_dir);
            fileOutputStream = new FileOutputStream(file_src);
            int len = 0;
            byte[] bytes = new byte[1024];

            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
                fileOutputStream.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 利用队列遍历文件夹下的文件夹和文件，保存到文件中，文件清单，队列调用
     *
     * @param file_dir 源文件(文件夹或文件)
     * @param file_out 目标文件清单
     * @throws Exception
     */
    public static void OutFileList(File file_dir, File file_out) throws Exception {
        Queue<File> queue = new Queue<File>();
        File[] files = file_dir.listFiles();
        for (File file : files) {
            isFile(file, file_out, queue);
        }
        while (!queue.isNull()) {
            File file = queue.myGet();
            for (File subFile : file.listFiles()) {
                isFile(subFile, file_out, queue);
            }
        }
    }

    /**
     * 判断是否为文件或文件夹
     */
    private static void isFile(File file, File file_out, Queue<File> queue) throws Exception {
        if (file.isDirectory()) {
            FileOut("files=" + file.getAbsolutePath(), file_out, true);
            queue.myAdd(file);
        } else {
            FileOut("file=" + file.getAbsolutePath(), file_out, true);
        }
    }

    /**
     * 遍历文件夹下的文件夹和文件，保存到文件中，文件清单，递归调用
     *
     * @param file_dir 源文件(文件夹或文件)
     * @param file_out 文件输出流，文件清单目标
     * @throws Exception
     */
    public static void GetFileList(File file_dir, File file_out) throws Exception {
        File[] files = file_dir.listFiles();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                FileOut("files【" + files[i].getAbsolutePath() + "】", file_out, true);
                GetFileList(files[i], file_out);
            } else if (files[i].isFile()) {
                FileOut("file【" + files[i].getAbsolutePath() + "】", file_out, true);
            }
        }
    }

    /**
     * 字符串保存到文件中
     *
     * @param string 等待保存的字符串;
     * @param file   指定保存的文件
     * @param append 是否续写标记，false 不续写，true 文件续写
     */
    public static void FileOut(String string, File file, Boolean append) throws Exception {
        FileOut(string, file, append, SystemUtils.CHARSET);
    }

    /**
     * @param CHARSET 指定的文件编码
     */
    public static void FileOut(String string, File file, Boolean append, String CHARSET) throws Exception {
        String charset = "utf-8";
        if (file.isDirectory()) {
            throw new Exception("not file exception");
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, append));
        outputStreamWriter.write(string + SystemUtils.LINE_SEPARATOR);
        outputStreamWriter.flush();
        outputStreamWriter.close();

    }

    /**
     * 获取文件夹下的文件和文件夹
     *
     * @param file 文件路径
     */
    public static Map<String, List> getFileList(File file) {
        Map<String, List> map = new LinkedHashMap<>();
        List<String> FileList = new LinkedList<>();
        List<String> FilesList = new LinkedList<>();
        //判断文件夹或文件夹存在
        if (!file.exists()) {
            return map;
        }
        //判断文件是否文件夹
        if (!file.isDirectory()) {
            ((LinkedList<String>) FileList).addLast(file.getAbsolutePath());
        } else {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    ((LinkedList<String>) FilesList).addLast(file1.getAbsolutePath());
                } else {
                    ((LinkedList<String>) FileList).addLast(file1.getAbsolutePath());
                }
            }
        }
        map.put("files", FilesList);
        map.put("file", FileList);
        return map;
    }


    /**
     * 获取文件夹下的所有文件
     *
     * @param path 文件路径
     */
    public static List<File> getListFiles(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        List<String> dirList = new ArrayList<String>();
        List<File> filesList = new ArrayList<File>();
        if (files != null) {
            int i = 0;
            for (File file : files) {
                if (file.isDirectory()) {
                    getListFiles(file.getAbsolutePath());
                } else if (file.isFile()) {
                    filesList.add(file);
                } else {
                    continue;
                }
            }
        }
        return filesList;
    }

    public static void getAllFilesOrFile(FileLinkedList<File> temp) {
        while (!temp.isNull()) {
            File tempfile = temp.get();
            System.out.println("文件夹:" + tempfile.getName());
            FileLinkedList<File> temp1 = getAllFileOrFileLinkedList(tempfile);
            getAllFilesOrFile(temp1);
        }

    }

    /**
     * 遍历文件或文件夹
     *
     * @author z
     */
    public static FileLinkedList<File> getAllFileOrFileLinkedList(File file) {
        FileLinkedList<File> fileslinklist = new FileLinkedList<File>();
        List<File> list = new LinkedList<File>();
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File dir : files) {
                if (dir.isDirectory()) {
                    fileslinklist.add(dir);
                } else {
                    list.add(dir);
                    System.out.println("文件:" + dir.getName());
                }
            }
        } else {
            throw new RuntimeException(file + "...文件或文件夹不存在");
        }
        return fileslinklist;
    }


    /**
     * 文件名批量重定义
     *
     * @param path     文件夹路径
     * @param newName  新字符串，
     * @param toString 需要配替换的字符串
     */
    public static void recursiveTraversalFolder(String path, String newName, String toString) throws FileNotFoundException {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                throw new FileNotFoundException(file.getAbsolutePath() + ":为空");
            } else {
                for (int i = 0; i < files.length; i++) {
                    File file1 = files[i];
                    if (file1.isDirectory()) {
                        recursiveTraversalFolder(file1.getAbsolutePath(), newName, toString);
                    } else {
                        //旧文件名
                        String fileName = file1.getName();
                        //文件夹路径
                        File filePath = file1.getParentFile();
                        //新文件名
                        if (fileName.contains(toString)) {
                            //文件名替换
                            String s = fileName.replaceAll(toString, newName);
                            //文件拼装
                            File file2 = new File(filePath + "/" + s);
                            file1.renameTo(file2);
                            System.out.println(file2.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

}
