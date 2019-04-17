package com.gecx.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/19 23:24
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "123456");
    }

    public Logger.Level getFeignLoggerLevle() {
        return feign.Logger.Level.FULL;
    }

}
