package cn.itcast.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * codening:utf-8
 *
 * @author :DataBaseConfiguration
 * @time :2019.08.28,10:28
 * @file :cn.itcast.config.DataBaseConfiguration.jave
 */
@Configuration
public class DataBaseConfiguration {

    @Value("${spring.datasource.default.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "defaultDataSource", destroyMethod = "close", initMethod = "init")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.default")
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 有多少个数据库就要配置多个
     */
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "readDataSource")
    public List<DataSource> readDataSource() {
        List<DataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(defaultDataSource());
        dataSourceList.add(dataSource());
        dataSourceList.add(testDataSource());
        return dataSourceList;
    }

}
