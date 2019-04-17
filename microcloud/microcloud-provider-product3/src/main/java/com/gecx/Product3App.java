package com.gecx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/15 1:14
 */
@SpringBootApplication
@MapperScan("com.gecx.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class Product3App {

    public static void main(String[] args) {
        SpringApplication.run(Product3App.class);
    }
}
