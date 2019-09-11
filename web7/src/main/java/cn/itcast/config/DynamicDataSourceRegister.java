package cn.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertyNameAliases;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源配置，
 * <p>
 * codening:utf-8
 *
 * @author :DynamicDataSourceRegister
 * @time :2019.08.28,9:53
 * @file :cn.itcast.config.DynamicDataSourceRegister.jave
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    /**
     * 配置文件的获取工具
     */
    private Environment environment;

    /**
     * 别名
     */
    private final static ConfigurationPropertyNameAliases ALIASES = new ConfigurationPropertyNameAliases();

    static {
        ALIASES.addAliases("url", new String[]{"jdbc_url"});
        ALIASES.addAliases("username", new String[]{"username"});
    }

    /**
     * 存储数据源
     */
    private Map<String, DruidDataSource> dataSourceMap = new HashMap<>();

    /**
     * 参数绑定工具
     */
    private Binder binder;

    /**
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry               current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Map config, defauleDataSourceProperties;
        defauleDataSourceProperties = binder.bind("spring.datasource.default.type", Map.class).get();

        String defaultTypestr = environment.getProperty("spring.datasource.default.type");
        /**
         * 获取数据源
         */

    }

    /**
     * Set the {@code Environment} that this component runs in.
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {

    }
}
