package cn.itcast.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * codening:utf-8
 *
 * @author :Druid
 * @time :2019.08.28,0:17
 * @file :cn.itcast.config.Druid.jave
 */
@Configuration
public class DruidConfiguration {

    @Value("${spring.druid.username}")
    private String username;
    @Value("${spring.druid.password}")
    private String userpassword;

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        servletRegistrationBean.addInitParameter("deny", "127.0.0.2");

        servletRegistrationBean.addInitParameter("loginUsername", username);
        servletRegistrationBean.addInitParameter("loginPassword", userpassword);

        servletRegistrationBean.addInitParameter("resetEnable", "false");

        return servletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean druidStatFilter() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        System.out.println("druid 初始化成功 run ...");


        return filterRegistrationBean;
    }


}
