package com.gecx.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/18 11:26
 */
@Configuration
public class RestConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 进行一个Http头信息配置
     *
     * @return
     */
    @Bean
    public HttpHeaders getHeaders() {
        // 定义一个HTTP的头信息
        HttpHeaders headers = new HttpHeaders();
        // 认证的原始信息
        String auth = "admin:123456";
        // 进行一个加密的处理
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        return headers;
    }


    /**
     * 此处为全局设置使用
     */
//    @Bean
//    public IRule ribbonRule() { // 其中IRule就是所有规则的标准
//        // 随机的访问策略
//        return new com.netflix.loadbalancer.RandomRule();
//    }


}
