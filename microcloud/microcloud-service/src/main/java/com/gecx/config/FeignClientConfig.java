package com.gecx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/19 23:24
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthenticationInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthenticationInterceptor("admin", "admin");
    }

}
