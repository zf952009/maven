package cn.itcast.config;

import cn.itcast.model.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro授权配置类
 * codening:utf-8
 *
 * @author :ShiroConfig
 * @time :2019.09.03,11:26
 * @file :cn.itcast.config.ShiroConfig.jave
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     *
     * @param securityManager
     * @return
     */
    public ShiroFilterFactoryBean getShiroFilterFactorBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/add", "authc");
        filterMap.put("/update", "authc");

        //设置安全管理器
        //shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     *
     * @param userRealm
     * @return
     */
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {

        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(userRealm);

        return webSecurityManager;
    }

    @Bean
    public UserRealm getUserRalm() {
        return new UserRealm();
    }
}
