package cn.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 默认数据源配置类
 * codening:utf-8
 *
 * @author :MyDataSourceConfig
 * @time :2019.08.27,23:35
 * @file :cn.itcast.config.MyDataSourceConfig.jave
 */
//@Configuration
@MapperScan(basePackages = MyDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mySqlSessionFactory")
public class MyDataSourceConfig {

    /**
     * 接口路径
     */
    static final String PACKAGE = "cn.itcast.mapper";
    /**
     * 接口配置文件映射路径
     */
    static final String MAPPER_LOCATION = "classpath:mapper/**.xml";

    @Value("${spring.datasource.default.url}")
    private String url;

    @Value("${spring.datasource.default.username}")
    private String username;

    @Value("${spring.datasource.default.password}")
    private String userpassword;

    @Value("${spring.datasource.default.driver-class-name}")
    private String dirverClassName;

    @Value("${spring.datasource.druid.initial-size}")
    private Integer initialSize;

    @Value("${spring.datasource.druid.min-idle}")
    private Integer minIdle;

    @Value("${spring.datasource.druid.max-active}")
    private Integer maxActive;

    @Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
    private Integer timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
    private Integer minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validation-query}")
    private String validationQuery;

    @Value("${spring.datasource.druid.test-while-idle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.test-on-borrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.test-on-return}")
    private boolean testOnReturn;

    @Value("${spring.datasource.druid.pool-prepared-statements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.druid.max-pool-prepared-statement-per-connection-size}")
    private Integer maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.druid.filters}")
    private String filters;

    @Value("${spring.datasource.druid.connection-properties}")
    private String connectionProperties;


    @Bean(name = "myDataSource")
    @Primary
    public DataSource myDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(userpassword);
        dataSource.setDriverClassName(dirverClassName);

        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        try {
            dataSource.setFilters(filters);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //dataSource.setConnectProperties(connectionProperties);
        return dataSource;
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(myDataSource());
    }

    public SqlSessionFactory sqlSessionFactory(@Qualifier("myDataSource") DataSource dataSource) throws Exception {

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MyDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
