package cn.itcast.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springMVC扩展配置
 * codening:utf-8
 *
 * @author :WebMvcConfig
 * @time :2019.08.25,16:40
 * @file :cn.itcast.config.WebMvcConfig.jave
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 默认请求主页
     * Configure simple automated controllers pre-configured with the response
     * status code and/or a view to render the response body. This is useful in
     * cases where there is no need for custom controller logic -- e.g. render a
     * home page, perform simple site URL redirects, return a 404 status with
     * HTML content, a 204 with no content, and more.
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**"/test 请求映射到login
         * 登录请求，映射到login
         * 支持中文
         * @author z
         * */
        registry.addViewController("/test").setViewName("login");
        registry.addViewController("/登录").setViewName("login");
        registry.addViewController("/").setViewName("list");
    }
}
