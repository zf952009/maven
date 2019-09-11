package cn.itcast.config;

import org.mybatis.spring.annotation.MapperScan;

/**
 * codening:utf-8
 *
 * @author :DefaulDataSourceConfig
 * @time :2019.09.07,1:15
 * @file :cn.itcast.config.DefaulDataSourceConfig.jave
 */
//@Configuration
@MapperScan(basePackages = MyDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "defaultSqlSessionFactory")
public class DefaulDataSourceConfig {

}
