package com.gecx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/4/17 18:23
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class, args);
    }

}
