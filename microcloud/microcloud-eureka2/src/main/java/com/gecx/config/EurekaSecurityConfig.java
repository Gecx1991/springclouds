package com.gecx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/18 14:26
 */
@Configuration
@EnableWebSecurity
public class EurekaSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf处理
        //CSRF（跨站请求伪造）处理,默认判断请求是否携带token，如果没有就拒绝访问
        http.csrf().disable();
        super.configure(http);
    }
}
