package cn.itcast.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.List;

/**
 * 动态切换SqlSessionFactory
 * codening:utf-8
 *
 * @author :MyBatisConfiguration
 * @time :2019.08.28,10:45
 * @file :cn.itcast.config.MyBatisConfiguration.jave
 */
@Configuration
@ConditionalOnClass({EnableTransactionManagement.class})
@Import({DataBaseConfiguration.class})
@MapperScan(basePackages = {"cn.itcast.mapper"})
public class MyBatisConfiguration {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Value("${spring.datasource.readsize}")
    private String dataSourceSize;

    @Qualifier("defaultDataSource")
    private String dataSource;

    @Qualifier("readDataSource")
    private List<DataSource> readDataSource;

    public AbstractRoutingDataSource routingDataSource() {
        int size = Integer.parseInt(dataSourceSize);
        return null;
    }

    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        return null;
    }

}
