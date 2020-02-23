package com.example.springbootthymeleaf.configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.example.springbootthymeleaf.realm.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/* ShiroConf的配置类 */
@Configuration
public class ShiroConf {
    /* 1.创建ShiroFilterFactoryBean  的Bean*/
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro内置过滤器  实现一些相关的拦截
        /**
         *  anon 无需登录认证就可访问
         *  authc 必须认证才能访问
         *  user  只要使用了rememberMe的功能就可以访问
         *  perms  该资源必须得到资源权限才能访问
         *  role   该资源必须得到角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login", "anon");
        filterMap.put("/register", "anon");
        filterMap.put("/link/register", "anon");
        filterMap.put("/link/*", "authc");
        filterMap.put("/system/*", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //设置拦截后的跳转页面
        shiroFilterFactoryBean.setLoginUrl("/login");


        return shiroFilterFactoryBean;

    }

    /* 2.创建DefaultWebSecurityManager 的Bean*/
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm) {
        DefaultWebSecurityManager df = new DefaultWebSecurityManager();
        df.setRealm(getShiroRealm());
        return df;
    }

    /**
     * 3.创建Realm的对象
     */
    @Bean(name = "shiroRealm")
    public ShiroRealm getShiroRealm() {
        ShiroRealm realm=new ShiroRealm();
        realm.setCredentialsMatcher(getHashedCredentialsMatcher());
        return realm;
    }

    /**
     * 配置ShiroDialect 配合thymeleaf shiro标签使用
     */
    @Bean(name = "shiroDialect")
    public ShiroDialect getShiroDialect()
    {
        return new ShiroDialect();
    }

    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher()
    {
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1903);
        return credentialsMatcher;
    }
}
