package cn.itcast.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

/**
 * codening:utf-8
 *
 * @author :MybatisGenerator
 * @time :2019.09.05,13:29
 * @file :cn.itcast.util.MybatisGenerator.jave
 */
public class MybatisGenerator {

    public static void main(String[] args) throws Exception {
        MybatisGenerator mybatisGenerator = new MybatisGenerator();
        mybatisGenerator.generator();
    }

    public void generator() throws Exception {
        ArrayList<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        // 指定你想工程配置文件
        File configFile = new File("C:\\user\\mave\\web7\\src\\main\\resources\\generator\\generatorConfig.xml");
        System.out.println(configFile.getAbsolutePath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }


}
