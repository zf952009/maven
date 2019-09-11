package cn.itcast.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * codening:utf-8
 *
 * @author :MyBatisPlusConfig
 * @time :2019.09.06,23:44
 * @file :cn.itcast.config.MyBatisPlusConfig.jave
 */
@Configuration
public class MyBatisPlusConfig {

    /**
     * mybaits-plus sql执行小路插件
     *
     * @return
     */
    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor();
    }

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
